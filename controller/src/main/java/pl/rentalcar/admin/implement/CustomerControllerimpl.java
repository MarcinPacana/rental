package pl.rentalcar.admin.implement;

import pl.rentalcar.*;
import pl.rentalcar.admin.CustomerController;
import pl.rentalcar.entity.Customer;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerControllerimpl implements CustomerController {

    private static final String UPDATE_CLIENT_FAILED = "Nie udało się zaktualizować danych klięta";

    CustomerService customerService;
    Validator validator;
    MessageService messageService;

    public CustomerControllerimpl() {
        this.customerService = new CustomerService();
        this.validator = new Validator();
        this.messageService = new MessageService();

    }

    @Override
    public void showCustomerListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.getAll();
        int size = customerList.size();
        System.out.println("customerList size is: "+size);
        request.setAttribute("customerList",customerList);
        PageUtility.forwardToPage(request,response, PageList.ADMIN_LIST_CUSTOMER);
    }

    @Override
    public void showCustomerEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.get(id);
        System.out.println("Imie: "+customer.getFirstName());
        System.out.println("email: "+customer.getEmail());

        request.setAttribute("customer",customer);

        PageUtility.forwardToPage(request,response,PageList.ADMIN_EDIT_CUSTOMER_FORM);
    }

    @Override
    public void showCustomerAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response,PageList.ADMIN_ADD_CUSTOMER_FORM);
    }

    @Override
    public void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = customerService.getCustomerFromRequest(request);
        boolean customerCorrect = validator.validateCustomerForAdd(customer);
        if (customerCorrect){
            Customer customerAdded = customerService.add(customer);
            if (customerAdded != null){
                request.setAttribute("message","Stworzono nowego klienta");
            }else {
                request.setAttribute("message","Podczas zapisu cos poszlo nie tak");
            }
        }else {
            request.setAttribute("message","Niepoprawnie wprowadzone dane");
        }
        showCustomerListPage(request,response);
    }

    @Override
    public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = customerService.get(Integer.parseInt(request.getParameter("id")));

        Customer customerFormRequest = customerService.getCustomerFromRequest(request);

        if (validator.validateCustomerForUpdate(customerFormRequest)){
            customerService.setNewDate(customer,customerFormRequest);

            customerService.update(customer);
            request.setAttribute("message","Dane klienta zostaly zmienione");
        }else {
            messageService.setMessage(request,UPDATE_CLIENT_FAILED, MsgType.WARNING);
            request.setAttribute("message","Nie udało zmienić sie danych klienta");
        }
        showCustomerListPage(request,response);
    }

    @Override
    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = customerService.get(Integer.parseInt(request.getParameter("id")));

        customerService.delete(customer);
        request.setAttribute("message","Usunieto klienta z bazy danych");

        showCustomerListPage(request,response);

    }
}
