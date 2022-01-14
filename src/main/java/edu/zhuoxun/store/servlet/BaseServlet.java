package edu.zhuoxun.store.servlet;

import edu.zhuoxun.store.dbutils.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Jash
 */

public class BaseServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Field[] fields = this.getClass().getDeclaredFields();
        Arrays.stream(fields).filter(field -> field.getType().getName().startsWith("edu.zhuoxun.store.dao"))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        field.set(this, DaoFactory.createDao(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
