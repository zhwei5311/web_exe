package top.zhwei.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.zhwei.domain.Province;
import top.zhwei.service.ProvinceService;
import top.zhwei.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //调用service查询
//        ProvinceService provinceService = new ProvinceServiceImpl();
//        List<Province> provinceList = provinceService.findAll();
//        //序列化list为json
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(provinceList);
        ProvinceService provinceService = new ProvinceServiceImpl();
        String json = provinceService.findAllJson();
        //响应结果
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
