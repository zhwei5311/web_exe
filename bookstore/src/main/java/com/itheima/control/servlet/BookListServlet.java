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

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/15 16:03
 */
@WebServlet("/bookListServlet")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageService pageService = new PageServiceImpl();
        List<Books> booksList = pageService.findAll();
        request.setAttribute("books",booksList);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
