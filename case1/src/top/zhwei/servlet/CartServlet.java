package top.zhwei.servlet;

import top.zhwei.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 21:02
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String,Product> map=(Map<String, Product>)request.getSession().getAttribute("cart");
        if(null == map || map.size() == 0) {
            String string = "<a href='/case1/demo01.html'>浏览商品</a>";
            writer.println("购物车中暂无商品信息"+string);
        } else {
            for(Product product : map.values()) {
                writer.println("商品名称:  "+product.getPname()+"<br/>");
                writer.println("商品价格:   "+product.getPrice()+"<br/>");
                writer.println("商品数量"+product.getNum()+"<br/><br/>");

            }
        }
        writer.println("<a href='/case1/demo01.html'>继续浏览商品</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
