package pl.rentalcar.impl;

import pl.rentalcar.GeneratorService;
import pl.rentalcar.dao.UserDao;
import pl.rentalcar.entity.User;

import java.util.List;

public class UserService {

    UserDao userDao;

    public UserService() {
        this.userDao =new UserDao();
    }


    public User get(int index) {
        return null;
    }


    public User add(User user) {
        return null;
    }


    public User update(User user) {
        return null;
    }


    public void delete() {

    }

    public List<User> getAll() {
        return null;
    }

    public boolean isEmailExist(String email) {
        return false;
    }

    public User login(String email, String password) {
        String passwordMD5 = GeneratorService.generateMD5(password);
        return userDao.checkLogin(email, passwordMD5);
    }
}
