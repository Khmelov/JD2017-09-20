package by.it.meshchenko.project.java.bll.Manager;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.beans.View.Manager.ManagRoomView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class ConstructorManagRoomsView {

    public static List<ManagRoomView> creator(DAO dao, User user) {

        List<ManagRoomView> res = null;
        ShoppingCenter shc;
        Address addr;
        Street street;
        City city;
        Country country;
        String addrName;
        LeaseRoom leaseRoom;

        // Список помещений конкретного манеджера
        List<Room> rooms = dao.room.getAll("WHERE Id = ANY " +
                "(SELECT RoomId FROM `ls_leaserooms` WHERE UserId = "+ user.getId()
                +" AND DateStopLease IS NULL)");
        if(rooms.size() > 0) {
            res = new ArrayList<>();
            for (Room room : rooms) {
                shc = dao.shoppingCenter.read(room.getShoppingCenterId());
                addr = dao.address.read(shc.getAddressId());
                street = dao.street.read(addr.getStreetId());
                city = dao.city.read(street.getCityId());
                country = dao.country.read(city.getCountryId());
                addrName = country.getName() + ", " + city.getName() + ", " +
                        street.getName() + "," + addr.getBuildingNumberStr();
                leaseRoom = dao.leaseRoom.getAll("WHERE RoomId = " + room.getId()
                        + " AND DateStopLease IS NULL ").get(0);

                res.add(new ManagRoomView(room, leaseRoom, shc, addrName));
            }
        }
        return res;
    }
}
