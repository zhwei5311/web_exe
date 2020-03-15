package com.itheima.control.servlet;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/15 15:58
 */
@WebServlet("/findBooksByPageServlet")
public class FindBooksByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1、获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //当前端没有传值到后台，设置当前页为1
        if(null == currentPage || "".equals(currentPage)) {
            currentPage = "1";
        }
        if(null == rows || "".equals(rows)) {
            rows = "5";
        }
        //2、获取条件查询参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调用service查询数据，传入分页条件与前端传入后端的条件
        PageServiceImpl service = new PageServiceImpl();
        PageBean<Books> pageBean = service.findBooksByPage(currentPage,rows,parameterMap);
        System.err.println("pageBean" + pageBean);
        //3、将PageBean存入request请求中
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("parameterMap",parameterMap);
        //4、转发至list.jsp
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
