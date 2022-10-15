package pl.rentalcar;

import javax.servlet.http.HttpServletRequest;

public class MessageService {

    private static final String MESSAGE = "message";

    private static final String EMAIL_EXIST = "Podany adres email juz istnieje";
    private static final String FAILED_LOGIN = "Niepoprawne dane logowania";

    public void setEmailExist(HttpServletRequest request){
        setMessageJSP(request);
    }

    public void setFailedLogin(HttpServletRequest request){
        request.setAttribute(MESSAGE,FAILED_LOGIN);
    }


     private void setMessageJSP(HttpServletRequest request){
        request.setAttribute("message",EMAIL_EXIST);
    }
}
