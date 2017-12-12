package by.it.meshchenko.project.java.beans.View.Admin;

import by.it.meshchenko.project.java.beans.View.ShoppingCenterView;

import java.util.List;

public class AdmRoomsView {


    private List<ShoppingCenterView> shoppingCentersView;

    public AdmRoomsView() {}

    public AdmRoomsView(List<ShoppingCenterView> shoppingCentersView) {
        this.shoppingCentersView = shoppingCentersView;
    }

    public List<ShoppingCenterView> getShoppingCentersView() {
        return shoppingCentersView;
    }

    public void setShoppingCentersView(List<ShoppingCenterView> shoppingCentersView) {
        this.shoppingCentersView = shoppingCentersView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdmRoomsView that = (AdmRoomsView) o;

        return shoppingCentersView != null ? shoppingCentersView.equals(that.shoppingCentersView) : that.shoppingCentersView == null;
    }

    @Override
    public int hashCode() {
        return shoppingCentersView != null ? shoppingCentersView.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AdmRoomsView{" +
                "shoppingCentersView=" + shoppingCentersView +
                "}\n";
    }
}
