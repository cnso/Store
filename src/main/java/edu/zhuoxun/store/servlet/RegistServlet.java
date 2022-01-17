package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import edu.zhuoxun.store.dao.UserDao;
import edu.zhuoxun.store.entry.User;
import edu.zhuoxun.store.utils.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegistServlet", value = "/regist-servlet")
public class RegistServlet extends BaseServlet {
    private UserDao userDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User test = userDao.getUserByUsername(username);
        if (test != null) {
            request.setAttribute("msg", "用户" + username + "已存在");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            return;
        }
        String password = StringUtils.toMD5(request.getParameter("password"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String sex = request.getParameter("sex");
        Date birthday = new Date();
        try {
            birthday = sdf.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(StringUtils.generateUUID(), username, password, name, email, telephone, birthday, sex);
        userDao.insertUser(user);
        response.sendRedirect("/");

    }
}
