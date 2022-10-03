package pl.rentalcar.dao;

import org.hibernate.Session;
import pl.rentalcar.entity.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO extends JpaDAO<Customer> implements GenericCRUD<Customer>{


    @Override
    public Customer create(Customer customer) {
        return super.create(customer);
    }

    @Override
    public Customer get(int id) {
        return null;
    }

    @Override
    public Customer update(Customer t) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Customer> getAll() {
        return super.findWithNameQuery("Customer.getAllCustomer");
    }


    public boolean emailExist(String email) {
        List<Customer> customerList = super.findWithNameQuery("Customer.findByEmail","email",email);
        if (customerList.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public Customer checkLogin(String email, String password) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("email",email);
        parameters.put("password",password);
        List<Customer> customerList = super.findWithNameQuery("Customer.checkLogin", parameters);
        if (!customerList.isEmpty()){
            return customerList.get(0);
        }else {
            return null;
        }
    }
}
