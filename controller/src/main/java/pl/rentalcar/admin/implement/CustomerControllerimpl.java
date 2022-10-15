package pl.rentalcar.admin.implement;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.admin.CustomerController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerControllerimpl implements CustomerController {
    @Override
    public void showCustomerListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response, PageList.ADMIN_LIST_CUSTOMER);
    }
}