package by.it.meshchenko.project.java.beans.View;

import by.it.meshchenko.project.java.beans.ShoppingCenter;

import java.util.List;

public class ShoppingCenterView {

    String address;
    List<RoomView> roomViews;
    ShoppingCenter shoppingCenter;

    public ShoppingCenterView() {}

    public ShoppingCenterView(String address, List<RoomView> roomViews, ShoppingCenter shoppingCenter) {
        this.address = address;
        this.roomViews = roomViews;
        this.shoppingCenter = shoppingCenter;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RoomView> getRoomViews() {
        return roomViews;
    }

    public void setRoomViews(List<RoomView> roomViews) {
        this.roomViews = roomViews;
    }

    public ShoppingCenter getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenter shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCenterView that = (ShoppingCenterView) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (roomViews != null ? !roomViews.equals(that.roomViews) : that.roomViews != null) return false;
        return shoppingCenter != null ? shoppingCenter.equals(that.shoppingCenter) : that.shoppingCenter == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (roomViews != null ? roomViews.hashCode() : 0);
        result = 31 * result + (shoppingCenter != null ? shoppingCenter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingCenterView{" +
                "address='" + address + '\'' +
                ", roomViews=" + roomViews +
                ", shoppingCenter=" + shoppingCenter +
                "}\n";
    }
}
