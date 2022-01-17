package edu.zhuoxun.store.dao;

import edu.zhuoxun.store.dbutils.Insert;
import edu.zhuoxun.store.dbutils.Select;
import edu.zhuoxun.store.entry.User;

import java.util.List;

/**
 * Created by Jash
 */
public interface UserDao {

    @Select("select * from user where username=?")
    User getUserByUsername(String username);

    @Select("select * from user")
    List<User> getAll();

    @Insert("insert into user(%s) values(?,?,?,?,?,?,?,?)")
    void insertUser(User user);
}
