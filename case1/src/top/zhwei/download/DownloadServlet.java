package top.zhwei.download;

import top.zhwei.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Ticket: DownLoadServlet
 *
 * @author zhwei
 * @email zhwei1228@qq.com
 * @Date: 2020/2/6 21:20
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、获取请求参数（文件名称）
        String filename = req.getParameter("filename");
        //2、使用字节输入流加载文件进内存
        //2.1 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/files/" + filename);
        //2.2 用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //3、设置response的响应头
        //3.1 设置响应头类型 content-type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        //解决中文文件名无法正常显示的问题
        //a.获取user-agent请求头
        String agent = req.getHeader("user-agent");
        //b.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent,filename);
        //3.2 设置响应头打开方式：content-disposition
        resp.setHeader("content-disposition","attachment;filename=" + filename);
        //4、将输入流中的数据写出到输出流中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
