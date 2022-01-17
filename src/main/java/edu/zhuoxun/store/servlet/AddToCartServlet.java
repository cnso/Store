package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.entry.Cart;
import edu.zhuoxun.store.entry.CartItem;
import edu.zhuoxun.store.entry.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart-servlet")
public class AddToCartServlet extends BaseServlet {
    private ProductDao productDao;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product product = productDao.getProductById(pid);
        String quantity = request.getParameter("quantity");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        Optional<CartItem> cartItem = cart.getCartItems().stream().filter(item -> pid.equals(item.getProduct().getPid())).findAny();
        if (cartItem.isPresent()) {
            cartItem.get().addNum(Integer.parseInt(quantity));
        } else {
            cart.getCartItems().add(new CartItem(product, Integer.parseInt(quantity)));
        }
        response.sendRedirect("/");
    }
}
