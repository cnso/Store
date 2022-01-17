package edu.zhuoxun.store.entry;

import edu.zhuoxun.store.dbutils.NoData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Jash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private String itemid;
    private Integer quantity;
    private Double total;
    private String pid;
    private String oid;
    @NoData
    private Product product;
}
