package pl.rentalcar.impl;

import pl.rentalcar.GeneratorService;
import pl.rentalcar.dao.UserDao;
import pl.rentalcar.entity.User;

import java.util.List;

public class UserService implements pl.rentalcar.UserService<User> {

    UserDao userDao;

    public UserService() {
        this.userDao =new UserDao();
    }

    @Override
    public User get(int index) {
        return null;
    }

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public User login(String email, String password) {
        System.out.println("password: "+password);
        String passwordMD5 = GeneratorService.generateMD5(password);
        System.out.println("passwordMD5: "+passwordMD5);
        return userDao.checkLogin(email, passwordMD5);
    }
}
