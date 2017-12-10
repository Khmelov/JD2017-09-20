package by.it.shelkovich.project.java.dao;

import java.util.List;

public interface IDAO<BeanType> {
    BeanType read(long id) throws  Exception;
    List<BeanType> read(BeanType bean) throws  Exception;
    boolean create(BeanType bean) throws Exception;
    Integer update(BeanType bean) throws Exception;
    boolean delete(long id) throws Exception;
    List<BeanType> getAll() throws Exception;
    List<BeanType> get(String condition) throws Exception;
}
