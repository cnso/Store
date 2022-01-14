package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import com.alibaba.fastjson.JSON;
import edu.zhuoxun.store.dao.CategoryDao;
import edu.zhuoxun.store.dbutils.DaoFactory;
import edu.zhuoxun.store.entry.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/store/category-servlet")
public class CategoryServlet extends BaseServlet {
    private CategoryDao categoryDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDao.getAll();
        response.setContentType("application/json");
        ServletOutputStream os = response.getOutputStream();
        os.write(JSON.toJSONString(categories).getBytes(StandardCharsets.UTF_8));
        os.flush();
    }
}
