package pl.rentalcar.servlets.admin.customer;

import pl.rentalcar.admin.CustomerController;
import pl.rentalcar.admin.implement.ManageCustomerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/listCustomer")
public class ListCustomerServlet extends HttpServlet {

    CustomerController customerController;

    public ListCustomerServlet( ) {
        this.customerController = new ManageCustomerController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      customerController.showCustomerListPage(req,resp);
    }
}
