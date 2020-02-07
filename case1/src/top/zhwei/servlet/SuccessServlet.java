package top.zhwei.servlet;

import top.zhwei.domain.User;
import top.zhwei.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        if (null != user) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("登录成功！" + user.getUsername() + ",欢迎您");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String remUser = req.getParameter("remUser");
//            Cookie cookieByName = CookieUtils.getCookieByName("username", req.getCookies());
            //判断是否勾选记住密码，如果勾选则处理cookie，否则不处理
            if (null != remUser && "yes".equals(remUser)) {
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                //设置cookie的存活时间为1小时
                cookie1.setMaxAge(60 * 60);
                cookie2.setMaxAge(60 * 60);
                //设置cookie的路径
                cookie1.setPath(req.getContextPath());
                cookie2.setPath(req.getContextPath());
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
        }
    }
}
