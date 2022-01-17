package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.OrderDao;
import edu.zhuoxun.store.entry.Cart;
import edu.zhuoxun.store.entry.Order;
import edu.zhuoxun.store.entry.OrderItem;
import edu.zhuoxun.store.entry.User;
import edu.zhuoxun.store.utils.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@WebServlet(name = "SaveOrderServlet", value = "/save-order-servlet")
public class SaveOrderServlet extends BaseServlet {
    private OrderDao orderDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("loginUser");
        Order order = new Order();
        order.setOid(StringUtils.generateUUID());
        order.setState(1);
        order.setTotal(cart.getTotal());
        order.setOrdertime(new Date());
        order.setUid(user.getUid());
        order.setList(cart.getCartItems().stream()
                .map(cartItem -> new OrderItem(StringUtils.generateUUID(),
                        cartItem.getNum(), cartItem.getSubTotal(), cartItem.getProduct().getPid(),
                        order.getOid(), null))
                .collect(Collectors.toList()));
        orderDao.insertOrder(order);
        order.getList().forEach(orderDao::insertOrderItem);
        response.sendRedirect("/find-order-servlet?currentPage=1&pageSize=2");
    }
}
