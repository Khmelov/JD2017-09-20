package by.it.meshchenko.project.java.bll.Admin;

import by.it.meshchenko.project.java.beans.City;
import by.it.meshchenko.project.java.beans.Country;
import by.it.meshchenko.project.java.beans.Role;
import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.beans.View.Admin.AdmCitiesView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.List;

public class ConstructorAdmCitiesView {

    public static AdmCitiesView creator(DAO dao) {

        AdmCitiesView res = null;

        List<City> cities = dao.city.getAll("");
        List<Country> countries = dao.country.getAll("");

        if (cities.size() > 0 && countries.size() > 0) {
            res = new AdmCitiesView(cities, countries);
        }
        return res;
    }
}
