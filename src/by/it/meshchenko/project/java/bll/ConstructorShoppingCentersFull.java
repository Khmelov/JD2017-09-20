package by.it.meshchenko.project.java.bll;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class ConstructorShoppingCentersFull {

    public static List<ShoppingCenterFull> creator(DAO dao){

        List<ShoppingCenterFull> res = null;
        List<ShoppingCenter> list = dao.shoppingCenter.getAll("");
        if(list.size() > 0) {
            res = new ArrayList<>();
            for(ShoppingCenter l: list) {
                ShoppingCenter sh = dao.shoppingCenter.read(l.getId());
                Address addr = dao.address.read(sh.getAddressId());
                Street street = dao.street.read(addr.getStreetId());
                City city = dao.city.read(street.getCityId());
                Country country = dao.country.read(city.getCountryId());
                res.add(new ShoppingCenterFull(sh, country, city, street, addr));
            }
        }
        return res;
    }
}
