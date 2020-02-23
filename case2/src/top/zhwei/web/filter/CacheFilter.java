package top.zhwei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ticket: CacheFilter
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/19 21:34
 */
@WebFilter(urlPatterns = {"*.jsp","*.png","*.js","*.css"},initParams = {
        @WebInitParam(name = "png",value = "1"),
        @WebInitParam(name = "css",value = "10"),
        @WebInitParam(name = "png",value = "20"),
        @WebInitParam(name = "jsp",value = "-1")
})
public class CacheFilter implements Filter {
    private FilterConfig config;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        int expires = 0;
        if (uri.endsWith("png")) {
            expires = Integer.parseInt(config.getInitParameter("png"));
        } else if(uri.endsWith("css")) {
            expires = Integer.parseInt(config.getInitParameter("css"));
        } else if(uri.endsWith("jsp")) {
            System.out.println(config.getInitParameter("jsp"));
            expires = Integer.parseInt(config.getInitParameter("jsp"));
        } else {
            System.err.println("文件格式不做过滤处理");
        }
        response.setDateHeader("Expires", System.currentTimeMillis()+expires*1000*60);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
