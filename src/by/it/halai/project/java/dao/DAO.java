package by.it.halai.project.java.dao;

public class DAO {

    private static DAO dao;

    public RolesDAO role; // UniversalDAO<Role> role;
    public UsersDAO user;
    public AdsDAO ad;


    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.role = new RolesDAO(); // UniversalDAO<>(new Role(), "roles");
                    dao.user = new UsersDAO();
                    dao.ad = new AdsDAO();
                }
            }
        }
        return dao;
    }
}
