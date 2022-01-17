package edu.zhuoxun.store.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();
    public Double getTotal() {
        return cartItems.stream().mapToDouble(CartItem::getSubTotal).sum();
    }
}
