package pl.rentalcar.impl;

import pl.rentalcar.GeneratorService;
import pl.rentalcar.dao.CustomerDAO;
import pl.rentalcar.entity.Customer;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class CustomerService {

    public CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }


    public Customer get(int index) {
        return customerDAO.get(index);
    }


    public Customer add(Customer customer) {

        customer.setRegisteredDate(LocalDateTime.now());
        customer.setPassword(GeneratorService.generateMD5(customer.getPassword()));
        return customerDAO.create(customer);
    }


    public Customer update(Customer customer) {

        return customerDAO.update(customer);
    }


    public void delete(Customer customer) {
        customerDAO.delete(customer.getId());
    }


    public List<Customer> getAll() {
        return customerDAO.getAll();
    }


    public boolean isEmailExist(String email) {
        return customerDAO.emailExist(email);
    }



    public Customer login(String email, String password){
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.checkLogin(email,password);
    }

    public Customer getCustomerFromRequest(HttpServletRequest request){
        Customer customer = new Customer();
        readCustomerFields(request, customer);
        return customer;
    }

    private void readCustomerFields(HttpServletRequest request, Customer customer) {
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setEmail(request.getParameter("email"));
        customer.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
        customer.setPassword(request.getParameter("password"));
        customer.setCountry(request.getParameter("country"));
        customer.setCity(request.getParameter("city"));
        customer.setStreet(request.getParameter("streat"));
        customer.setFlatNumber(request.getParameter("flatNumber"));
        customer.setZipCode(request.getParameter("zipCode"));
        customer.setToken(request.getParameter("token"));
        customer.setActive(Boolean.parseBoolean(request.getParameter("active")));
    }


    public void setNewDate(Customer customer, Customer customerFormRequest) {
        customer.setFirstName(customerFormRequest.getFirstName());
        customer.setLastName(customerFormRequest.getLastName());
        customer.setEmail(customerFormRequest.getEmail());
        customer.setPhoneNumber(customerFormRequest.getPhoneNumber());

        customer.setCountry(customerFormRequest.getCountry());
        customer.setCity(customerFormRequest.getCity());
        customer.setStreet(customerFormRequest.getStreet());
        customer.setFlatNumber(customerFormRequest.getFlatNumber());
        customer.setZipCode(customerFormRequest.getZipCode());

        customer.setActive(customerFormRequest.isActive());
    }
}
