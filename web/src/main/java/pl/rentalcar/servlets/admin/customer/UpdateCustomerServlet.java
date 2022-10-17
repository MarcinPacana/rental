package pl.rentalcar.servlets.admin.customer;

import pl.rentalcar.admin.CustomerController;
import pl.rentalcar.admin.implement.CustomerControllerimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerController customerController = new CustomerControllerimpl();
        customerController.updateCustomer(req,resp);
    }
}
