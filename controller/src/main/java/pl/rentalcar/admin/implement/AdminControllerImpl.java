package pl.rentalcar.admin.implement;

import pl.rentalcar.MessageService;
import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.UserService;
import pl.rentalcar.admin.AdminController;
import pl.rentalcar.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminControllerImpl implements AdminController {

    UserService<User> userService;
    MessageService messageService;

    public AdminControllerImpl() {
        this.userService = new pl.rentalcar.impl.UserService();
        this.messageService = new MessageService();
    }

    @Override
    public void loginAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("metoda: loginAdmin(): start ");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.login(email, password);
        if (user != null){
            System.out.println("loginAdmin: TAK");
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser",user);
            PageUtility.forwardToPage(request,response, PageList.ADMIN_HOME_PAGE);
        }else {
            System.out.println("loginAdmin: NIE");
            messageService.setFailedLogin(request);
            PageUtility.forwardToPage(request,response,PageList.ADMIN_LOGIN_PAGE);
        }
    }

    @Override
    public void logOutAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("logOUT");
        HttpSession session = request.getSession();
        session.removeAttribute("loggedUser");
        PageUtility.sendRedirect(request,response,request.getContextPath()+"/admin/");
    }

    @Override
    public void showLoginFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response,PageList.ADMIN_LOGIN_PAGE);
    }

    @Override
    public void showAdminHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response,PageList.ADMIN_HOME_PAGE);
    }
}
