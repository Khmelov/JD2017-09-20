package by.it.ali.project.java.dao;

public class Tickets {
    private int id;
    private String Destination;
    private String Company;
    private String Date;
    private int Price;
    private int FKusers;

    public Tickets() {
    }


    public Tickets(int id, String Destination, String Company, String Date, int Price, int FKusers) {
        this.id = getId();
        this.Destination = Destination;
        this.Company = Company;
        this.Date = Date;
        this.Price = Price;
        this.FKusers = FKusers;
    }

    public Tickets(String Destination, String Company, String Date, int Price, int FKusers) {
        this.id = getId();
        this.Destination = Destination;
        this.Company = Company;
        this.Date = Date;
        this.Price = Price;
        this.FKusers = FKusers;
    }
//
//    public User(String login, String password, String email, int fk_Roles, int fk_Roles_additional) {
//        this.id = 0;
//        this.login = login;
//        this.password = password;
//        this.email = email;
//        this.fk_Roles = fk_Roles;
//        this.fk_Roles_additional = fk_Roles_additional;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getPrice() {
        return Price;
    }
    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void Price(int Price) {
        this.Price = Price;
    }

    public int getFKusers() {
        return FKusers;
    }

    public void setFKusers(int FKusers) { this.FKusers = FKusers; }

    @Override
    public String toString() {
        return "\nTicket{" +
                "id=" + id +
                ", Destination='" + Destination + '\'' +
                ", Company='" + Company + '\'' +
                ", Date='" + Date + '\'' +
                ", Price=" + Price +'\'' +
                ", FKusers=" + FKusers +
                '}';
    }

}