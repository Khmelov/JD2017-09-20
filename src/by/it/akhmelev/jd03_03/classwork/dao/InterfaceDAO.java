package by.it.akhmelev.jd03_03.classwork.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    boolean create(T entity) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(T entity) throws SQLException;
    T read(T entity) throws SQLException;
    List<T> getAll() throws SQLException;
    List<T> getAll(String WhereAndOreder) throws SQLException;
}
