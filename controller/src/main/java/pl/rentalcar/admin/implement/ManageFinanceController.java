package pl.rentalcar.admin.implement;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.admin.FinanseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinanseControllerImpl implements FinanseController {
    @Override
    public void showFinanseHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response, PageList.ADMIN_FINANSE_HOME_PAGE);
    }
}
