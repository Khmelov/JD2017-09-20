package by.it.meshchenko.project.java.beans.View.Admin;

import by.it.meshchenko.project.java.beans.City;
import by.it.meshchenko.project.java.beans.Country;

import java.util.List;

public class AdmCitiesView {

    private List<City> cities;
    private List<Country> countries;

    public AdmCitiesView(List<City> cities, List<Country> countries) {
        this.cities = cities;
        this.countries = countries;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdmCitiesView that = (AdmCitiesView) o;

        if (cities != null ? !cities.equals(that.cities) : that.cities != null) return false;
        return countries != null ? countries.equals(that.countries) : that.countries == null;
    }

    @Override
    public int hashCode() {
        int result = cities != null ? cities.hashCode() : 0;
        result = 31 * result + (countries != null ? countries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdmCitiesView{" +
                "cities=" + cities +
                ", countries=" + countries +
                "}\n";
    }
}
