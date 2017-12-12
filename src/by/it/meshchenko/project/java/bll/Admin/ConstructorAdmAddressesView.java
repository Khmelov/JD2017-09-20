package by.it.meshchenko.project.java.bll.Admin;

import by.it.meshchenko.project.java.beans.Address;
import by.it.meshchenko.project.java.beans.Street;
import by.it.meshchenko.project.java.beans.View.Admin.*;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.List;

public class ConstructorAdmAddressesView {

    public static AdmAddressesView creator(DAO dao) {

        AdmAddressesView res = null;

        List<Address> addresses = dao.address.getAll("");
        AdmStreetsView admStreetsView = ConstructorAdmStreetsView.creator(dao);

        if (admStreetsView != null && addresses.size() > 0) {
            res = new AdmAddressesView(admStreetsView, addresses);
        }
        return res;
    }
}
