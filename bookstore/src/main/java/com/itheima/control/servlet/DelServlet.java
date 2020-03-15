package com.itheima.control.servlet;

import com.itheima.service.PageService;
import com.itheima.service.impl.PageServiceImpl;

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
 * @Date: 2020/3/15 15:58
 */
@WebServlet("/delServlet")
public class DelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //2、获取要删除的id
        String id = request.getParameter("id");
        //3、调用Service的删除方法
        PageService service = new PageServiceImpl();
        service.delete(id);
        //4、跳转到userListServlet
        response.sendRedirect(request.getContextPath() + "/findBooksByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
