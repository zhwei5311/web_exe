package top.zhwei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

@WebServlet("/getAPIServlet02")
public class GetAPIServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HashSet set=(HashSet)getServletContext().getAttribute("ips");
        if(null!=set&&set.size()>0){
            Iterator iterator = set.iterator();
            resp.getWriter().print("访问过本网张的IP有:<br/>");
            while(iterator.hasNext()){
                String val=(String)iterator.next();
                resp.getWriter().print(val+"<br/>");
            }
        }else{
            resp.getWriter().print("当前网站还没有被访问过<br/>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
