package pl.rentalcar;

import javax.servlet.http.HttpServletRequest;

public class SimpleClassService {

    private int variable;

    public SimpleClassService(int i) {
        this.variable = i;
    }

    public int count(int j){
        return variable + j;
    }

    public static void printData(HttpServletRequest req, String servletName){

        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String idSession = req.getSession().getId();

        System.out.println(servletName);
        System.out.println("requestURI: "+requestURI);
        System.out.println("requestURL: "+requestURL);
        System.out.println("contextPath: "+contextPath);
        System.out.println("servletPath: "+servletPath);
        System.out.println("idSession: "+idSession);
    }
}
