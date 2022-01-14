package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.UserDao;
import edu.zhuoxun.store.dbutils.DaoFactory;
import edu.zhuoxun.store.entry.User;
import edu.zhuoxun.store.utils.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends BaseServlet {
    private UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            request.setAttribute("msg", "用户" + username + "未注册");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else if (!user.getPassword().equals(StringUtils.toMD5(password))) {
            request.setAttribute("msg", "密码与用户名不符");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("loginUser", user);
            response.sendRedirect("/index-servlet");
        }
    }
}
