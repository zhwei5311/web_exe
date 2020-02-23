package top.zhwei.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Ticket: LoginServlet
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/23 19:52
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //准备防止登录结果信息的map，最后会将map转换为json字符串
        Map<Object, Object> resultMap = new HashMap<>();
        //1、获取用户名
        String name = request.getParameter("username");
        //2、验证用户名不为空
        if(null == name || name.trim().equals("")) {
            //如果为空，则在map中添加错误信息
            //0代表失败，作为前端判断依据
            resultMap.put("type",0);
            //添加状态描述信息
            resultMap.put("msg","用户名不能为空！");
        } else {
            //1代表成功
            resultMap.put("type",1);
            //添加状态描述信息
            resultMap.put("msg","欢迎" + name + "登录！");
        }
        //3、将结果转换为json字符串输出到浏览器
        //{"type":1,"msg":"欢迎您回来!tom"}
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        //将json数据传递给客户端
        objectMapper.writeValue(response.getWriter(),resultMap);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
