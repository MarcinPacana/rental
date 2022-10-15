package pl.rentalcar.impl;

import pl.rentalcar.entity.Customer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class PrinterService {

    public static void printData(HttpServletRequest req, String servletName) {
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String idSession = req.getSession().getId();
        Object redirectURL = req.getSession().getAttribute("redirectURL");
        String redirectString = (String) redirectURL;

        System.out.println("----------" + servletName + "----------");
        System.out.println("requestURI: " + requestURI);
        System.out.println("requestURL: " + requestURL);
        System.out.println("contextPath: " + contextPath);
        System.out.println("servletPath: " + servletPath);
        System.out.println("idSession: " + idSession);
        System.out.println("redirectURL: " + redirectString);
        System.out.println("------------------------------");
    }

    public static void printDataFromFilter(ServletRequest request) {
        int serverPort = request.getServerPort();
        int remotePort = request.getRemotePort();
        String remoteHost = request.getRemoteHost();
        int localPort = request.getLocalPort();
        String localName = request.getLocalName();
        String localAddr = request.getLocalAddr();

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        String contextPath = httpServletRequest.getContextPath();
        String servletPath = httpServletRequest.getServletPath();
        HttpSession session = httpServletRequest.getSession(false);
        boolean present = false;
        try {
            Optional<Object> optional = Optional.ofNullable(session.getAttribute("loggedCustomer"));
            present = optional.isPresent();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        String queryString = httpServletRequest.getQueryString();

        System.out.println("----------START----------");
        System.out.println("serverPort: " + serverPort);
        System.out.println("requestURI: " + requestURI);
        System.out.println("requestURL: " + requestURL);
        System.out.println("contextPath: " + contextPath);
        System.out.println("servletPath: " + servletPath);
        System.out.println("remotePort "+remotePort);
        System.out.println("remoteHost "+remoteHost);
        System.out.println("localPort "+localPort);
        System.out.println("localName "+localName);
        System.out.println("localAddr "+localAddr);
        System.out.println("loggedCustomer: " + present);
        System.out.println("queryString: " + queryString);

        System.out.println("----------END----------");

    }

}
