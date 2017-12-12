package by.it.meshchenko.project.java.beans.View.Admin;

import by.it.meshchenko.project.java.beans.Street;

import java.util.List;

public class AdmStreetsView {

    AdmCitiesView admCitiesView;
    List<Street> streets;

    public AdmStreetsView() {
    }
    public AdmStreetsView(AdmCitiesView admCitiesView, List<Street> streets) {
        this.admCitiesView = admCitiesView;
        this.streets = streets;
    }

    public AdmCitiesView getAdmCitiesView() {
        return admCitiesView;
    }

    public void setAdmCitiesView(AdmCitiesView admCitiesView) {
        this.admCitiesView = admCitiesView;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdmStreetsView that = (AdmStreetsView) o;

        if (admCitiesView != null ? !admCitiesView.equals(that.admCitiesView) : that.admCitiesView != null)
            return false;
        return streets != null ? streets.equals(that.streets) : that.streets == null;
    }

    @Override
    public int hashCode() {
        int result = admCitiesView != null ? admCitiesView.hashCode() : 0;
        result = 31 * result + (streets != null ? streets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdmStreetsView{" +
                "admCitiesView=" + admCitiesView +
                ", streets=" + streets +
                "}\n";
    }
}
