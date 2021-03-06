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
    @Select("select * from product where is_hot=1 order by pdate desc limit ?")
    List<Product> getHots(int size);

    @Select("select * from product order by pdate desc limit ?")
    List<Product> getNews(int size);

    @Select("select * from product where pid=?")
    Product getProductById(String pid);
    @Select("select * from product where pname like ? or pdesc like ? limit ?, ?")
    List<Product> searchProduct(String keyword, String keyword1, int offset, int size);
    @Select("select count(*) from product where pname like ? or pdesc like ?")
    int searchCount(String keyword, String keyword1);
}
