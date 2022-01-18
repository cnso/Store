package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.OrderDao;
import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.entry.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/order-servlet")
public class OrderServlet extends BaseServlet {
    private OrderDao orderDao;
    private ProductDao productDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        Order order = orderDao.getOrderByOid(oid);
        order.setList(orderDao.findOrderItemByOid(oid));
        order.getList().forEach(item -> item.setProduct(productDao.getProductById(item.getPid())));
        request.setAttribute("order", order);
        request.getRequestDispatcher("/jsp/order_info.jsp").forward(request, response);
    }

}
