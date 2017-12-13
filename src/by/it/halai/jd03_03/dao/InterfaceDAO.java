package by.it.halai.jd03_03.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    //interface InterfaceDAO<TYPE> {
//    //READ чтение отдельной сущности
    T read(int id) throws SQLException;

    ;
//    //CREATE,UPDATE,DELETE обновление сущности
//    boolean create(TYPE entity);
//    boolean update(TYPE entity);
//    boolean delete(TYPE entity);
//
//    //READ - чтение всех элементов по условию
//    List<TYPE> getAll(String WhereAndOrder);
//    //и другие необходимые системе операции


    boolean create(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;

    T read(T entity) throws SQLException;

    List<T> getAll() throws SQLException;

    List<T> getAll(String WhereAndOrder) throws SQLException;

}
