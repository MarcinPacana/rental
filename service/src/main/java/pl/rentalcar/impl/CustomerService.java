package pl.rentalcar.impl;

import pl.rentalcar.dao.CustomerDAO;
import pl.rentalcar.entity.Customer;

import java.util.List;

public class CustomerService implements pl.rentalcar.UserService<Customer> {

    public CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    @Override
    public Customer get(int index) {
        return customerDAO.get(index);
    }

    @Override
    public Customer add(Customer customer) {
        return customerDAO.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }


    public boolean isEmailExist(String email) {
        return customerDAO.emailExist(email);
    }


    @Override
    public Customer login(String email, String password){
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.checkLogin(email,password);
    }




}
