package pl.rentalcar.dao;

import java.util.List;

public interface GenericCRUD<E> {
    public E create(E t);
    public E get(int id);
    public E update(E t);
    public void delete(int id);
    public List<E> getAll();

}
