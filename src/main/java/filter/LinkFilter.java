package filter;

import service.FieldService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LinkFilter implements Filter {

    FieldService fieldService = new FieldService();

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String pageRequested = req.getRequestURL().toString();
        String path = null;
        pageRequested = pageRequested.substring(pageRequested.lastIndexOf("/"));

        System.out.println("pageRequested" + pageRequested);

        if (pageRequested.equals("/")) {

            path = "/test.xhtml";
            RequestDispatcher rd = req.getRequestDispatcher(path);
            rd.forward(req, resp);
        } else if (pageRequested.equals("/responses") || pageRequested.equals("/responses.xhtml")) {
            path = "/responses.xhtml";
            RequestDispatcher rd = req.getRequestDispatcher(path);
            rd.forward(req, resp);
        } else if (pageRequested.equals("/fields") || pageRequested.equals("/fields.xhtml")) {
            path = "/fields.xhtml";
            RequestDispatcher rd = req.getRequestDispatcher(path);
            rd.forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
