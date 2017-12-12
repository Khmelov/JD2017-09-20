package by.it.meshchenko.project.java.beans.View.Manager;

import by.it.meshchenko.project.java.beans.LeaseRoom;
import by.it.meshchenko.project.java.beans.Room;
import by.it.meshchenko.project.java.beans.ShoppingCenter;
import by.it.meshchenko.project.java.beans.View.Admin.AdmShoppingCentersView;

import java.util.List;

public class ManagRoomView {

    private Room room;
    private LeaseRoom leaseRoom;
    private ShoppingCenter shoppingCenter;
    private String address;

    public ManagRoomView() {}

    public ManagRoomView(Room room, LeaseRoom leaseRoom, ShoppingCenter shoppingCenter, String address) {
        this.room = room;
        this.leaseRoom = leaseRoom;
        this.shoppingCenter = shoppingCenter;
        this.address = address;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LeaseRoom getLeaseRoom() {
        return leaseRoom;
    }

    public void setLeaseRoom(LeaseRoom leaseRoom) {
        this.leaseRoom = leaseRoom;
    }

    public ShoppingCenter getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenter shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
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

        ManagRoomView that = (ManagRoomView) o;

        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        if (leaseRoom != null ? !leaseRoom.equals(that.leaseRoom) : that.leaseRoom != null) return false;
        if (shoppingCenter != null ? !shoppingCenter.equals(that.shoppingCenter) : that.shoppingCenter != null)
            return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (leaseRoom != null ? leaseRoom.hashCode() : 0);
        result = 31 * result + (shoppingCenter != null ? shoppingCenter.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ManagRoomView{" +
                "room=" + room +
                ", leaseRoom=" + leaseRoom +
                ", shoppingCenter=" + shoppingCenter +
                ", address='" + address + '\'' +
                '}';
    }
}
