package pl.rentalcar.dao;

import pl.rentalcar.entity.Customer;
import pl.rentalcar.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao extends JpaDAO<User> implements GenericCRUD<User>{

    @Override
    public User create(User t) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User update(User t) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }


    public User checkLogin(String email, String password) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("email",email);
        parameters.put("password",password);
        List<User> userList = super.findWithNameQuery("User.checkLogin", parameters);
        if (!userList.isEmpty()){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
