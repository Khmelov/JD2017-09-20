package by.it.meshchenko.project.java.beans.View;

import by.it.meshchenko.project.java.beans.ShoppingCenter;

public class LeaseView {

    private String address;
    private ShoppingCenter shoppingCenter;
    private int count;

    public LeaseView() {}

    public LeaseView(String address, ShoppingCenter shoppingCenter, int count) {
        this.address = address;
        this.shoppingCenter = shoppingCenter;
        this.count = count;
    }

    public ShoppingCenter getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenter shoppingCenters) {
        this.shoppingCenter = shoppingCenters;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaseView leaseView = (LeaseView) o;

        if (count != leaseView.count) return false;
        if (address != null ? !address.equals(leaseView.address) : leaseView.address != null) return false;
        return shoppingCenter != null ? shoppingCenter.equals(leaseView.shoppingCenter) : leaseView.shoppingCenter == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (shoppingCenter != null ? shoppingCenter.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "LeaseView{" +
                "address='" + address + '\'' +
                ", shoppingCenter=" + shoppingCenter +
                ", count=" + count +
                "}\n";
    }
}
