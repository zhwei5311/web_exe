package top.zhwei.web.servlet;

import top.zhwei.domain.User;
import top.zhwei.service.UserService;
import top.zhwei.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/15 23:35
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取id
        String id = request.getParameter("id");
        //2、调用Service方法查询该记录
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        //3、将User存入request
        request.setAttribute("user",user);
        //4、转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
