package by.it.ali.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InDAO<TYPE> {
//    boolean create(User user) throws SQLException;
//
//    boolean create(Tickets tickets) throws SQLException;
//
//    boolean update(User user) throws SQLException;
//
//    boolean delete(User user) throws SQLException;
//
//    User read(User user) throws SQLException;
//
//    List<User> getAll() throws SQLException;
//
//    List<User> getAll(String WhereAndOreder) throws SQLException;


        //READ чтение отдельной сущности
        TYPE read(TYPE entity)throws SQLException;
        //CREATE,UPDATE,DELETE обновление сущности
        boolean create(TYPE entity)throws SQLException;
        boolean update(TYPE entity)throws SQLException;
        boolean delete(TYPE entity)throws SQLException;

        //READ - чтение всех элементов по условию
        List<TYPE> getAll(String WhereAndOrder)throws SQLException;
        //и другие необходимые системе операции


}
