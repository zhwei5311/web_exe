package top.zhwei.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ticket: ${file_name}
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/7 21:00
 */
@WebServlet("/getCookieServlet")
public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式及编码
        response.setContentType("text/html;charset=utf-8");
        //1、获取所有cookies
        Cookie[] cookies = request.getCookies();
        //设置标志位判断是否存在名为lastTime的cookie
        boolean flag = false;
        //2、遍历cookies数组
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3、获取cookie的名称
                String name = cookie.getName();
                //4、判断名称是否是：lastTime
                if("lastTime".equals(name)) {
                    //获取cookie的value，时间
                    String value = cookie.getValue();
                    //证明有该cookie，不是第一次访问，flag置为true
                    flag = true;
                    //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String dateString = dateFormat.format(date);
                    //设置URL编码
                    dateString = URLEncoder.encode(dateString,"utf-8");
                    //设置cookie一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    cookie.setValue(dateString);
                    response.addCookie(cookie);
                    //响应数据

                    value = URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次的访问时间为：" + value + "</h1>");

                    break;
                }
            }
        }
        if(cookies == null || cookies.length == 0 || flag == false) {
            //没有cookie，表示是第一次访问
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String dateString = dateFormat.format(date);
            Cookie cookie = new Cookie("lastTime", dateString);
            //设置cookie一个月
            //设置URL编码
            dateString = URLEncoder.encode(dateString,"utf-8");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setValue(dateString);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎首次登录</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
