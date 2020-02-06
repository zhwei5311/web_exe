package top.zhwei.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet("/getAPIServlet01")
public class GetAPIServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = getServletContext();
        String remoteAddr = req.getRemoteAddr();
        HashSet set=(HashSet)servletContext.getAttribute("ips");
        if(null==set){
            set=new HashSet<String>();
            getServletContext().setAttribute("ips", set);
        }
        if(!set.contains(remoteAddr)){
            set.add(remoteAddr);
        }
        resp.getWriter().println("欢迎使用我们的系统,您的IP是:"+remoteAddr+"<br/>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
