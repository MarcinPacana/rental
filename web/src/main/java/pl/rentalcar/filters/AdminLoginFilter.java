package pl.rentalcar.filters;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);

        boolean userLoggedIn = session != null && session.getAttribute("loggedUser") != null;

        String requestURI = request.getRequestURI();
        String loginURI = request.getContextPath().concat("/admin/loginAdmin");
        boolean loginRequest = requestURI.equals(loginURI);

        if (userLoggedIn && loginRequest ){
            PageUtility.forwardToPage(servletRequest,servletResponse,"/admin/");
        }else if (userLoggedIn || loginRequest){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            PageUtility.forwardToPage(servletRequest,servletResponse,PageList.ADMIN_LOGIN_PAGE);
        }

    }

    @Override
    public void destroy() {

    }
}
