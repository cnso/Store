package edu.zhuoxun.store.filter; /**
 * Created by Jash
 */

import edu.zhuoxun.store.entry.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "UserFilter", value = {"/add-to-cart-servlet",
        "/clear-cart-servlet", "/store/del-from-cart-servlet", "/find-order-servlet",
        "/order-servlet", "/pay-servlet", "/save-order-servlet"})
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        User loginUser = (User) ((HttpServletRequest) request).getSession().getAttribute("loginUser");
        if (loginUser == null || loginUser.getUid() == null) {
            ((HttpServletResponse) response).sendRedirect("/jsp/login.jsp");
        } else {
            chain.doFilter(request, response);
        }

    }
}
