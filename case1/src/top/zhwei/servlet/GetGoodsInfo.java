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
import java.util.HashMap;
import java.util.Map;

/**
 * Ticket: GetGoodsInfo
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 20:53
 */
@WebServlet("/getGoodsInfo")
public class GetGoodsInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String pid = request.getParameter("pid");
        int num = Integer.parseInt(request.getParameter("num"));
        Map<String, Product> map = (Map<String, Product>) request.getSession().getAttribute("cart");
        if (null == map) {
            map = new HashMap<>();
            request.getSession().setAttribute("cart",map);
        }
        if(!map.containsKey(pid)) {
            Product product = GoodsInfo.getProductById(pid);
            product.setNum(1);
            map.put(pid,product);
        } else {
            Product product = map.get(pid);
            product.setNum(product.getNum() + num);
        }
        writer.println("商品加入购物车成功<br/>");
        writer.println("<a href='/case1/demo01.html'>请继续浏览商品</a><br/>");
        writer.println("<a href='/case1/cartServlet'>浏览购物车</a><br/>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
