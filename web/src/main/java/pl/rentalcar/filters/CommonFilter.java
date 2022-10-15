package pl.rentalcar.filters;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.impl.PrinterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CommonFilter implements Filter {

    private static final String JSP = ".jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //PrinterService.printDataFromFilter(servletRequest);
        boolean isJspPage = httpServletRequest.getRequestURI().endsWith(JSP);
        if (isJspPage){
            HttpServletResponse response =(HttpServletResponse) servletResponse;

            String responsURL = "http://localhost:"
                    .concat(String.valueOf(servletRequest.getLocalPort()))
                    .concat(((HttpServletRequest) servletRequest).getContextPath());
            response.sendRedirect(responsURL);
         //   PageUtility.forwardToPage(servletRequest,servletResponse, PageList.HOME_PAGE);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
