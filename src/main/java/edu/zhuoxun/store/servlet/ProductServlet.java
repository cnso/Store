package edu.zhuoxun.store.servlet;

import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.entry.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * Created by Jash
 */

@WebServlet(name = "ProductServlet", value = "/store/product-servlet")
public class ProductServlet extends BaseServlet {
    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product product = productDao.getProductById(pid);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/jsp/product_info.jsp").forward(request, response);
    }
}
