package services.interfaces;

import java.util.List;

public interface ICRUD<T> {

    List<T> getAll(String nameQuery, Class<T> clazz);

    void insert(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(Integer id, Class<T> clazz);
}