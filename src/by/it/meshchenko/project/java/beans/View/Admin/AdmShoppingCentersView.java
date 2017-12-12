package by.it.meshchenko.project.java.beans.View.Admin;

import by.it.meshchenko.project.java.beans.ShoppingCenter;

import java.util.List;

public class AdmShoppingCentersView {

    private AdmAddressesView admAddressesView;
    private List<ShoppingCenter> shoppingCenters;

    public AdmShoppingCentersView() {
    }

    public AdmShoppingCentersView(AdmAddressesView admAddressesView, List<ShoppingCenter> shoppingCenters) {
        this.admAddressesView = admAddressesView;
        this.shoppingCenters = shoppingCenters;
    }

    public AdmAddressesView getAdmAddressesView() {
        return admAddressesView;
    }

    public void setAdmAddressesView(AdmAddressesView admAddressesView) {
        this.admAddressesView = admAddressesView;
    }

    public List<ShoppingCenter> getShoppingCenters() {
        return shoppingCenters;
    }

    public void setShoppingCenters(List<ShoppingCenter> shoppingCenters) {
        this.shoppingCenters = shoppingCenters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdmShoppingCentersView that = (AdmShoppingCentersView) o;

        if (admAddressesView != null ? !admAddressesView.equals(that.admAddressesView) : that.admAddressesView != null)
            return false;
        return shoppingCenters != null ? shoppingCenters.equals(that.shoppingCenters) : that.shoppingCenters == null;
    }

    @Override
    public int hashCode() {
        int result = admAddressesView != null ? admAddressesView.hashCode() : 0;
        result = 31 * result + (shoppingCenters != null ? shoppingCenters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdmShoppingCentersView{" +
                "admAddressesView=" + admAddressesView +
                ", shoppingCenters=" + shoppingCenters +
                "}\n";
    }
}
