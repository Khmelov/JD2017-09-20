package by.it.meshchenko.project.java.bll;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.beans.View.LeaseView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class ConstructorLeaseView {

    public static List<LeaseView> creator(DAO dao) {

        List<LeaseView> lv = null;
        List<ShoppingCenter> temp = dao.shoppingCenter.getAll("");
        if (temp.size() > 0) {
            int count = 0;
            lv = new ArrayList<>();
            for (ShoppingCenter sh : temp) {
                count = dao.room.getAll(
                        "WHERE ShoppingCenterId="+ sh.getId() +
                        " AND Id = ANY(SELECT RoomId FROM `ls_leaserooms` WHERE RoomId = Id" +
                        " AND DateStopLease IS NULL AND DateStartLease IS NULL)").size();
                int idStreet = dao.address.read(sh.getAddressId()).getStreetId();
                int idCity = dao.street.read(idStreet).getCityId();
                String city = dao.city.read(idCity).getName();
                lv.add(new LeaseView(city, sh, count));
            }
        }
        return lv;
    }
}
