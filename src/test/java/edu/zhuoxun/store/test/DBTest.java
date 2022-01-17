package edu.zhuoxun.store.test;

import edu.zhuoxun.store.dao.CategoryDao;
import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.dao.UserDao;
import edu.zhuoxun.store.dbutils.DaoFactory;
import edu.zhuoxun.store.entry.User;
import edu.zhuoxun.store.utils.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * Created by Jash
 */
public class DBTest {
    @Test
    public void testUser() {
//        try {
//            User ccc = DaoFactory.getQr().query("select * from user where username=?", new BeanHandler<>(User.class), "ccc");
//            System.out.println(ccc);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        UserDao dao = DaoFactory.createDao(UserDao.class);
//        User ccc = dao.getUserByUsername("ccc");
//        System.out.println(ccc);
//        System.out.println("=============");
//        dao.getAll().forEach(System.out::println);
        User user = new User(StringUtils.generateUUID(), "testuser", "123456", "测试用户", "1@2233.net", "", new Date(), "男");
        dao.insertUser(user);
    }
    @Test
    public void testCategory() {
        CategoryDao dao = DaoFactory.createDao(CategoryDao.class);
        dao.getAll().forEach(System.out::println);
    }

    @Test
    public void testProduct() {
        ProductDao dao = DaoFactory.createDao(ProductDao.class);
//        dao.getAll().forEach(System.out::println);
//        System.out.println(dao.getCount());
//        dao.getPage(10, 10).forEach(System.out::println);
//        dao.getAllByCategory("1").forEach(System.out::println);
//        System.out.println(dao.getCountByCategory("1"));
//        dao.getPageByCategory("1", 10, 10).forEach(System.out::println);
        dao.getHots(10).forEach(System.out::println);
    }

}
