package edu.zhuoxun.store.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Jash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int num;
    public double getSubTotal(){
        return product.getShop_price() * num;
    }
    public void addNum(int num){
        this.num += num;
    }
}
