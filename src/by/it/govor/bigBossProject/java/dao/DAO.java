package by.it.govor.bigBossProject.java.dao;


public class DAO {

    private static DAO dao;

    public UserDAO user;
    public AdDAO ad;
    public AddressDAO address;
    public RoleDAO role;


    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.ad = new AdDAO();
                    dao.address = new AddressDAO();
                    dao.role = new RoleDAO();
                }
            }
        }
        return dao;
    }

}
