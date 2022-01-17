package edu.zhuoxun.store.entry;

import edu.zhuoxun.store.dbutils.NoData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by Jash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String oid;
    private Date ordertime;
    private Double total;
    private Integer state;
    private String address;
    private String name;
    private String telephone;
    private String uid;
    @NoData
    private List<OrderItem> list;

}
