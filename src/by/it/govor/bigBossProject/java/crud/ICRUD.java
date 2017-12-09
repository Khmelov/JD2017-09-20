package by.it.govor.bigBossProject.java.crud;


import java.sql.SQLException;

public interface ICRUD<T> {
     boolean create(T entity) throws SQLException;
     boolean update(T entity) throws SQLException;
     boolean delete(T entity) throws SQLException;
}
