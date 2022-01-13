package edu.zhuoxun.store.dbutils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by Jash
 */
public class DaoFactory {
    private static final DataSource dataSource;
    private static final QueryRunner qr;
    static {
        Properties properties = new Properties();
        DataSource temp = new DruidDataSource();
        try {
            properties.load(DaoFactory.class.getClassLoader().getResourceAsStream("db.properties"));
            temp = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataSource = temp;
        qr = new QueryRunner(dataSource);
    }

    public static<T> T createDao(Class<T> clazz) {
        Object o = Proxy.newProxyInstance(DaoFactory.class.getClassLoader(), new Class[]{clazz}, new MyInvocationHandler());
        return (T)o;
    }
    private static class MyInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Select select = method.getAnnotation(Select.class);
            if (select != null) {
                if (method.getReturnType() == List.class) {
                    Type type = ((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments()[0];
                    return qr.query(select.value(), new BeanListHandler<>((Class<?>) type), args);
                } else if (method.getReturnType() == Integer.TYPE){
                    return qr.query(select.value(), new ScalarHandler<Long>(), args).intValue();
                } else {
                    return qr.query(select.value(), new BeanHandler<>(method.getReturnType()), args);
                }
            }
            return null;
        }
    }

}
