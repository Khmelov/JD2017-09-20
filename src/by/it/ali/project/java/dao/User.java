package by.it.ali.project.java.dao;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int fk_Roles;
    private int fk_Roles_additional;

    public User() {
    }


    public User(int id, String login, String password, String email, int fk_Roles, int fk_Roles_additional) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_Roles = fk_Roles;
        this.fk_Roles_additional = fk_Roles_additional;
    }

    public User(String login, String password, String email, int fk_Roles, int fk_Roles_additional) {
        this.id = 0;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_Roles = fk_Roles;
        this.fk_Roles_additional = fk_Roles_additional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFk_Roles() {
        return fk_Roles;
    }

    public void setFk_Roles(int fk_Roles) {
        this.fk_Roles = fk_Roles;
    }

    public int getFk_Roles_additional() {
        return fk_Roles_additional;
    }

    public void setFk_Roles_additional(int fk_Roles_additional) { this.fk_Roles = fk_Roles_additional; }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", fk_Roles='" + fk_Roles + '\'' +
                ", fk_Roles_additional=" + fk_Roles_additional +
                '}';
    }
}
