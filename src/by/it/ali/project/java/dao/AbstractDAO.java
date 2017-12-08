package by.it.ali.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/ali";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";
    /** return id or -1 (fail)*/
//    int executeCreate(String sql) throws SQLException {
//        int result=-1;
//        try (Connection connection= ConnectionCreator.getConnection();
//             Statement statement=connection.createStatement();){
//            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)==1){
//                ResultSet keys=statement.getGeneratedKeys();
//                keys.next();
//                result=keys.getInt(1);
//            }
//        }
//        return result;
//    }


    int executeUpdate(String sql) throws SQLException {
        int result=-1;
        try (Connection connection= DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement=connection.createStatement();){
            result =statement.executeUpdate(sql);
        }
    return result;}


//    public abstract boolean create(User user) throws SQLException;
//
//    public abstract boolean update(User user) throws SQLException;
//
//    public abstract boolean delete(User user) throws SQLException;
//
//    public abstract User read(User user) throws SQLException;
//
//    public abstract List<User> getAll() throws SQLException;
//
//    public abstract List<User> getAll(String WhereAndOreder) throws SQLException;
}
