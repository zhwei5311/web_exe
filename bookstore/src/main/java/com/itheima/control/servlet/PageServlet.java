package com.itheima.control.servlet;

import com.itheima.domain.Books;
import com.itheima.service.PageService;
import com.itheima.service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Ticket: PageServlet
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/12 21:57
 */
@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    private PageService pageService = new PageServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //设置默认值
        if(null == currentPage || "".equals(currentPage)) {
            currentPage = "1";
        }
        if(null == rows || "".equals(rows)) {
            rows = "5";
        }
        //获取查询条件
        Map<String, String[]> parameterMap = request.getParameterMap();
//        //调用service查询
//        String bookJson = pageService.findAll();
//        //响应结果
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(bookJson);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
