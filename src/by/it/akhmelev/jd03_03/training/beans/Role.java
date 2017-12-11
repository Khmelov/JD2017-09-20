package by.it.akhmelev.jd03_03.training.beans;

public class Role {
    private int id;
    private String Role;

    public Role() {
    }

    public Role(int id, String role) {
        this.id = id;
        Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", Role='" + Role + '\'' +
                "}\n";
    }
}
