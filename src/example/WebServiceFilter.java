package example;

import javax.servlet.*;
import javax.xml.ws.Endpoint;
import java.io.IOException;

public class WebServiceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化Filter。。。");
        Object implementor = new HelloWorld ();
        String address = "http://localhost:9000/HelloWorld";
        Endpoint.publish(address, implementor);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行doFilter方法。。。");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁Filter。。。");
    }
}
