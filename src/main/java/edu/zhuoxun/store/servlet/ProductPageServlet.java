package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.ProductDao;
import edu.zhuoxun.store.dbutils.DaoFactory;
import edu.zhuoxun.store.entry.Page;
import edu.zhuoxun.store.entry.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductPageServlet", value = "/store/product-page-servlet")
public class ProductPageServlet extends BaseServlet {
    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int total = productDao.getCountByCategory(cid);
        Page<Product> page = new Page<>();
        page.setCid(cid);
        if (total != 0) {
            List<Product> list = productDao.getPageByCategory(cid, pageSize * (currentPage - 1), pageSize);
            page.setCurrentPage(currentPage);
            page.setTotal(total);
            page.setTotalPage((int) Math.ceil(total * 1.0 / pageSize));
            page.setList(list);
        }
        request.setAttribute("product_page", page);
        request.getRequestDispatcher("/jsp/product_list.jsp").forward(request, response);
    }

}
