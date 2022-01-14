package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.dbutils.DaoFactory;
import edu.zhuoxun.store.entry.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "index-servlet", value = "/index-servlet")
public class IndexServlet extends BaseServlet {
    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> hots = productDao.getHots(9);
        request.setAttribute("hots", hots);
        List<Product> news = productDao.getNews(9);
        request.setAttribute("news", news);
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
