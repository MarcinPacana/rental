package pl.rentalcar;

import pl.rentalcar.entity.Customer;

import java.util.List;

public interface UserService<T> {
    T get(int index);
    T add(T t);
    T update(T t);
    void delete();
    List<T> getAll();
    boolean isEmailExist(String email);
    T login(String email, String password);


}
