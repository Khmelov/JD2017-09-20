package by.it.halai.project.java.beans;

public class Role {

    private int ID;
    private String Role;

    public Role() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Role(int ID, String role) {
        this.ID = ID;
        Role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        by.it.halai.project.java.beans.Role role = (by.it.halai.project.java.beans.Role) o;

        if (ID != role.ID) return false;
        return Role != null ? Role.equals(role.Role) : role.Role == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Role != null ? Role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
    }
}
