package edu.zhuoxun.store.dao;

import edu.zhuoxun.store.dbutils.Select;
import edu.zhuoxun.store.entry.Product;

import java.util.List;

/**
 * Created by Jash
 */
public interface ProductDao {
    @Select("select * from product")
    List<Product> getAll();
    @Select("select count(*) from product")
    int getCount();
    @Select("select * from product limit ?, ?")
    List<Product> getPage(int offset, int size);
    @Select("select * from product where cid=?")
    List<Product> getAllByCategory(String cid);
    @Select("select count(*) from product where cid=?")
    int getCountByCategory(String cid);
    @Select("select * from product where cid=? limit ?, ?")
    List<Product> getPageByCategory(String cid, int offset, int size);
}
