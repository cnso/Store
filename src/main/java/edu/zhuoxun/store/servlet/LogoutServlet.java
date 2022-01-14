package edu.zhuoxun.store.servlet; /**
 * Created by Jash
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout-servlet")
public class LogoutServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect("/index-servlet");
    }
}
