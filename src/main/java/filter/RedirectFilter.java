package filter;

import service.FieldService;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectFilter implements Filter {

    FieldService fieldService = new FieldService();
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        Boolean isList = false;
        String pageRequested = req.getRequestURL().toString();
        Integer separator = pageRequested.lastIndexOf("fields/");
        if (separator == -1) {
            isList = true;
        }

        if (!isList) {
            Integer fieldId = Integer.valueOf(pageRequested.substring(pageRequested.lastIndexOf("/") + 1));
            req.getSession().setAttribute("number",fieldId);
            RequestDispatcher rd = req.getRequestDispatcher("/editField.xhtml");
            rd.forward(req, resp);
        } else if (isList) {
            RequestDispatcher rd = req.getRequestDispatcher("/fields.xhtml");
            rd.forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {}

}
