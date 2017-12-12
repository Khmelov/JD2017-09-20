package by.it.meshchenko.project.java.bll.Admin;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.beans.View.Admin.AdmRoomsView;
import by.it.meshchenko.project.java.beans.View.RoomView;
import by.it.meshchenko.project.java.beans.View.ShoppingCenterView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class ConstructorAdmRoomsView {

    public static AdmRoomsView creator(DAO dao) {

        AdmRoomsView res = null;

        List<ShoppingCenter> shoppingCenters = dao.shoppingCenter.getAll("");
        List<ShoppingCenterView> shoppingCentersView = new ArrayList<>();

        for (ShoppingCenter shc : shoppingCenters){
            shoppingCentersView.add(creator(dao, shc.getId()));
        }

        if (shoppingCentersView.size() > 0) {
            res = new AdmRoomsView(shoppingCentersView);
        }
        return res;
    }

    private static ShoppingCenterView creator(DAO dao, int shoppingCenterId){
        ShoppingCenter sh = dao.shoppingCenter.read(shoppingCenterId);

        Address addr = dao.address.read(sh.getAddressId());
        Street street = dao.street.read(addr.getStreetId());
        City city = dao.city.read(street.getCityId());
        Country country = dao.country.read(city.getCountryId());
        String addrName = sh.getName() + ", " + country.getName() + ", " + city.getName() + ", " +
                street.getName() + "," + addr.getBuildingNumberStr();

        List<RoomView> roomsView = new ArrayList<>();
        List<Room> rooms = dao.room.getAll("WHERE ShoppingCenterId=" + shoppingCenterId);
        for(Room r : rooms){
            List<User> users = dao.user.getAll("WHERE Id = ANY " +
                    "(SELECT UserId FROM `ls_leaserooms` WHERE RoomId = "+ r.getId() +
                    " )");
            List<LeaseRoom> leaseRooms =
                    dao.leaseRoom.getAll("WHERE RoomId = " + r.getId());
            if(users.size() > 0 && leaseRooms.size() > 0)
                roomsView.add(new RoomView(r, users.get(0), leaseRooms.get(0)));
        }
        ShoppingCenterView shv = new ShoppingCenterView(addrName, roomsView, sh);
        return shv;
    }
}
