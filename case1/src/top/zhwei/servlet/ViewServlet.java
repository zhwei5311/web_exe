package top.zhwei.servlet;

import top.zhwei.dao.GoodsInfo;
import top.zhwei.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 20:39
 */
@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        //获取pid
        String pid = request.getParameter("pid");
        //根据pid查询一条记录
        Product product = GoodsInfo.getProductById(pid);
        printWriter.println("<form action='/case1/getGoodsInfo' method='post'>");
        printWriter.println("编号:<input type='text' name='pid' value='"+product.getPid()+"'/><br/>");
        printWriter.println("名称:" + product.getPname() + "<br/>");
        printWriter.println("简介:"+product.getPdesc()+"<br/>");
        printWriter.println("价格:"+product.getPrice()+"<br/>");
        printWriter.println("数量:<input type='text' name='num' value='1'/><br/>");
        printWriter.println("<input type='submit' value='加入购物车'/>");
        printWriter.println("</form>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
