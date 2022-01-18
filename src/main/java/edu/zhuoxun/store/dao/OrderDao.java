package edu.zhuoxun.store.dao;

import edu.zhuoxun.store.dbutils.Insert;
import edu.zhuoxun.store.dbutils.Select;
import edu.zhuoxun.store.dbutils.Update;
import edu.zhuoxun.store.entry.Order;
import edu.zhuoxun.store.entry.OrderItem;

import java.util.List;

/**
 * Created by Jash
 */
public interface OrderDao {

    @Insert("insert into orders(%s) values(?,?,?,?,?,?,?,?)")
    void insertOrder(Order order);

    @Insert("insert into orderitem(%s) values(?,?,?,?,?)")
    void insertOrderItem(OrderItem item);
    @Select("select count(*) from orders where uid=? order by ordertime desc")
    int getCountByUid(String uid);

    @Select("select * from orders where uid=? order by ordertime desc limit ?,?")
    List<Order> findOrderByUid(String uid, int offset, int size);

    @Select("select * from orderitem where oid=?")
    List<OrderItem> findOrderItemByOid(String oid);

    @Select("select * from orders where oid=?")
    Order getOrderByOid(String oid);

    @Update("update orders set state=?, name=?, telephone=?, address=? where oid=?")
    int updateOrder(int state, String name, String telephone, String address, String oid);
}
