package pl.rentalcar.servlets.admin.customer;

import pl.rentalcar.admin.CustomerController;
import pl.rentalcar.admin.implement.ManageCustomerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerController customerController = new ManageCustomerController();
        customerController.deleteCustomer(req,resp);
    }
}
