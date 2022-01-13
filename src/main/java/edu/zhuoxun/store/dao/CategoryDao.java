package edu.zhuoxun.store.dao;

import edu.zhuoxun.store.dbutils.Select;
import edu.zhuoxun.store.entry.Category;

import java.util.List;

/**
 * Created by Jash
 */
public interface CategoryDao {
    @Select("select * from category")
    List<Category> getAll();
}
