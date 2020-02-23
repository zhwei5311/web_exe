package top.zhwei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Ticket: TestFilter
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/18 20:47
 */
@WebFilter("/*")
public class TestFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
