package by.it.meshchenko.project.java.beans.View.Admin;

import by.it.meshchenko.project.java.beans.Address;

import java.util.List;

public class AdmAddressesView {

    AdmStreetsView admStreetsView;
    List<Address> addresses;

    public AdmAddressesView() {
    }
    public AdmAddressesView(AdmStreetsView admStreetsView, List<Address> addresses) {
        this.admStreetsView = admStreetsView;
        this.addresses = addresses;
    }

    public AdmStreetsView getAdmStreetsView() {
        return admStreetsView;
    }

    public void setAdmStreetsView(AdmStreetsView admStreetsView) {
        this.admStreetsView = admStreetsView;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdmAddressesView that = (AdmAddressesView) o;

        if (admStreetsView != null ? !admStreetsView.equals(that.admStreetsView) : that.admStreetsView != null)
            return false;
        return addresses != null ? addresses.equals(that.addresses) : that.addresses == null;
    }

    @Override
    public int hashCode() {
        int result = admStreetsView != null ? admStreetsView.hashCode() : 0;
        result = 31 * result + (addresses != null ? addresses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdmAddressesView{" +
                "admStreetsView=" + admStreetsView +
                ", addresses=" + addresses +
                "}\n";
    }
}
