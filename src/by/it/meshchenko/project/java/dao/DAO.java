package by.it.meshchenko.project.java.dao;

public class DAO {

    private static DAO dao;

    public AddressDAO address;
    public CityDAO city;
    public CountryDAO country;
    public LeaseRoomDAO leaseRoom;
    public RoomDAO room;
    public ShoppingCenterDAO shoppingCenter;
    public StreetDAO street;
    public UserDAO user;
    public RoleDAO role;

    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.address = new AddressDAO();
                    dao.city = new CityDAO();
                    dao.country = new CountryDAO();
                    dao.leaseRoom = new LeaseRoomDAO();
                    dao.room = new RoomDAO();
                    dao.shoppingCenter = new ShoppingCenterDAO();
                    dao.street = new StreetDAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                }
            }
        }
        return dao;
    }
}
