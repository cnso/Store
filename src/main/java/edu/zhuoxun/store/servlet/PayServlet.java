package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.OrderDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PayServlet", value = "/pay-servlet")
public class PayServlet extends BaseServlet {
    private OrderDao orderDao;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        orderDao.updateOrder(2, name, telephone, address, oid);
        response.sendRedirect("/find-order-servlet?currentPage=1&pageSize=2");
    }
}
