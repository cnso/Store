package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.OrderDao;
import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.entry.Order;
import edu.zhuoxun.store.entry.Page;
import edu.zhuoxun.store.entry.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FindOrderServlet", value = "/find-order-servlet")
public class FindOrderServlet extends BaseServlet {
    private OrderDao orderDao;
    private ProductDao productDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Page<Order> page = new Page<>();
        page.setCurrentPage(currentPage);
        int total = orderDao.getCountByUid(user.getUid());
        page.setTotal(total);
        if (total > 0) {
            page.setTotalPage((int) Math.ceil(total * 1.0 / pageSize));
            page.setList(orderDao.findOrderByUid(user.getUid(), (currentPage - 1) * pageSize, pageSize));
            page.getList().forEach(order -> {
                order.setList(orderDao.findOrderItemByOid(order.getOid()));
                order.getList().forEach(item -> item.setProduct(productDao.getProductById(item.getPid())));
            });
        }
        request.setAttribute("orderPage", page);
        request.getRequestDispatcher("/jsp/order_list.jsp").forward(request, response);
    }

}
