package by.it.meshchenko.project.java.bll.Admin;

import by.it.meshchenko.project.java.beans.City;
import by.it.meshchenko.project.java.beans.Country;
import by.it.meshchenko.project.java.beans.Street;
import by.it.meshchenko.project.java.beans.View.Admin.AdmCitiesView;
import by.it.meshchenko.project.java.beans.View.Admin.AdmStreetsView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.List;

public class ConstructorAdmStreetsView {

    public static AdmStreetsView creator(DAO dao) {

        AdmStreetsView res = null;

        List<Street> streets = dao.street.getAll("");
        AdmCitiesView admCitiesView = ConstructorAdmCitiesView.creator(dao);

        if (admCitiesView != null && streets.size() > 0) {
            res = new AdmStreetsView(admCitiesView, streets);
        }
        return res;
    }
}
