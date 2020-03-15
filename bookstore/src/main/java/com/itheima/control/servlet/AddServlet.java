package com.itheima.control.servlet;

import com.itheima.domain.Books;
import com.itheima.service.PageService;
import com.itheima.service.impl.PageServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/15 15:57
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1、设置编码
        request.setCharacterEncoding("utf-8");
        //2、获取参数集合
        Map<String, String[]> map = request.getParameterMap();
        //3、封装对象
        Books books = new Books();
        try {
            BeanUtils.populate(books,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4、调用Service保存
        PageService service = new PageServiceImpl();
        service.add(books);
        //5、跳转到userListServlet
        response.sendRedirect(request.getContextPath() + "/findBooksByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
