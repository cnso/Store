package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.entry.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DelFromCartServlet", value = "/store/del-from-cart-servlet")
public class DelFromCartServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getCartItems().removeIf(cartItem -> pid.equals(cartItem.getProduct().getPid()));
        if (cart.getCartItems().isEmpty()) {
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/jsp/cart.jsp");
        }
    }

}
