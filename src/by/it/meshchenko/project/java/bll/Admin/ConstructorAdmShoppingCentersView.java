package by.it.meshchenko.project.java.bll.Admin;

import by.it.meshchenko.project.java.beans.ShoppingCenter;
import by.it.meshchenko.project.java.beans.View.Admin.AdmAddressesView;
import by.it.meshchenko.project.java.beans.View.Admin.AdmShoppingCentersView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.List;

public class ConstructorAdmShoppingCentersView {

    public static AdmShoppingCentersView creator(DAO dao) {

        AdmShoppingCentersView res = null;

        AdmAddressesView admAddressesView = ConstructorAdmAddressesView.creator(dao);
        List<ShoppingCenter> shoppingCenters = dao.shoppingCenter.getAll("");

        if (admAddressesView != null && shoppingCenters.size() > 0) {
            res = new AdmShoppingCentersView(admAddressesView, shoppingCenters);
        }
        return res;
    }
}
