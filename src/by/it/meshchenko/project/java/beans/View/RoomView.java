package by.it.meshchenko.project.java.beans.View;

import by.it.meshchenko.project.java.beans.LeaseRoom;
import by.it.meshchenko.project.java.beans.Room;
import by.it.meshchenko.project.java.beans.User;

public class RoomView {

    private Room room;
    private User user;
    private LeaseRoom leaseRoom;

    public RoomView() {
    }

    public RoomView(Room room, User users, LeaseRoom leaseRooms) {
        this.room = room;
        this.user = users;
        this.leaseRoom = leaseRooms;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User users) {
        this.user = user;
    }

    public LeaseRoom getLeaseRoom() {
        return leaseRoom;
    }

    public void setLeaseRoom(LeaseRoom leaseRoom) {
        this.leaseRoom = leaseRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomView roomView = (RoomView) o;

        if (room != null ? !room.equals(roomView.room) : roomView.room != null) return false;
        if (user != null ? !user.equals(roomView.user) : roomView.user != null) return false;
        return leaseRoom != null ? leaseRoom.equals(roomView.leaseRoom) : roomView.leaseRoom == null;
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (leaseRoom != null ? leaseRoom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoomView{" +
                "room=" + room +
                ", user=" + user +
                ", leaseRoom=" + leaseRoom +
                '}';
    }
}

