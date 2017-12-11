package by.it.akhmelev.jd03_03.training.dao;

public class DAO {

    private DAO() {}

    private static DAO instance;

    public UserDAO user;
    public static DAO getInstance(){
        if (instance==null){
            instance=new DAO();
            instance.user=new UserDAO();
        }
    return instance;
    }
}
