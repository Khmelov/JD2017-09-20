package by.it.meshchenko.project.java.beans.View.Admin;

import by.it.meshchenko.project.java.beans.*;

import java.util.List;

public class AdmUsersView {

    private List<User> users;
    private List<Role> roles;

    public AdmUsersView() {}

    public AdmUsersView(List<User> users, List<Role> roles) {
        this.users = users;
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdmUsersView that = (AdmUsersView) o;

        if (users != null ? !users.equals(that.users) : that.users != null) return false;
        return roles != null ? roles.equals(that.roles) : that.roles == null;
    }

    @Override
    public int hashCode() {
        int result = users != null ? users.hashCode() : 0;
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdmUsersView{" +
                "users=" + users +
                ", roles=" + roles +
                "}\n";
    }
}
