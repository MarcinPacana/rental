package pl.rentalcar.filters;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.impl.PrinterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {

    private static final String[] LOGIN_REQUIRED = {"/profile"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      //  PrinterService.printDataFromFilter(servletRequest);

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(false);
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

        if (path.equals("/admin/")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        boolean customerLoggedIn = session != null && session.getAttribute("loggedCustomer") != null;

        String requestURL = httpServletRequest.getRequestURL().toString();

        if (!customerLoggedIn && isLoginRequiredUrl(requestURL)){
            String queryString = httpServletRequest.getQueryString();
            String redirectURL = requestURL;
            if (queryString != null){
                redirectURL = requestURL.concat("?").concat(queryString);
            }
            session.setAttribute("redirectURL",redirectURL);
            PageUtility.forwardToPage(servletRequest,servletResponse, PageList.LOGIN_PAGE);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean isLoginRequiredUrl(String requestURL){
        for (String loginRequiredURL : LOGIN_REQUIRED) {
            if (requestURL.contains(loginRequiredURL)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
    }


}
