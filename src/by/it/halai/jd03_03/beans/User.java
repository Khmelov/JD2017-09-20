package by.it.halai.jd03_03.beans;

public class User {
    private int ID;
    private String Login;
    private String Password;
    private String Email;
    private int FK_roles;

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getFK_roles() {
        return FK_roles;
    }

    public void setFK_roles(int FK_roles) {
        this.FK_roles = FK_roles;
    }

    public User(int ID, String login, String password, String email, int FK_roles) {
        this.ID = ID;
        Login = login;
        Password = password;
        Email = email;
        this.FK_roles = FK_roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (FK_roles != user.FK_roles) return false;
        if (Login != null ? !Login.equals(user.Login) : user.Login != null) return false;
        if (Password != null ? !Password.equals(user.Password) : user.Password != null) return false;
        return Email != null ? Email.equals(user.Email) : user.Email == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Login != null ? Login.hashCode() : 0);
        result = 31 * result + (Password != null ? Password.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + FK_roles;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", FK_roles=" + FK_roles +
                '}';
    }
}
