package edu.zhuoxun.store.test;

import edu.zhuoxun.store.dao.UserDao;
import edu.zhuoxun.store.dbutils.DaoFactory;
import edu.zhuoxun.store.entry.User;
import org.junit.jupiter.api.Test;

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
        User ccc = dao.getUserByUsername("ccc");
        System.out.println(ccc);
        System.out.println("=============");
        dao.getAll().forEach(System.out::println);
    }
}
