package by.it.halai.jd03_03.beans;

public class Ad {
    private int ID;
    private String Name;
    private String Genre;
    private int Number_Of_Players;
    private double price;
    private String Description;
    private int FK_Users;

    public Ad() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getNumber_Of_Players() {
        return Number_Of_Players;
    }

    public void setNumber_Of_Players(int number_Of_Players) {
        Number_Of_Players = number_Of_Players;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    public Ad(int ID, String name, String genre, int number_Of_Players, double price, String description, int FK_Users) {
        this.ID = ID;
        Name = name;
        Genre = genre;
        Number_Of_Players = number_Of_Players;
        this.price = price;
        Description = description;
        this.FK_Users = FK_Users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (ID != ad.ID) return false;
        if (Number_Of_Players != ad.Number_Of_Players) return false;
        if (Double.compare(ad.price, price) != 0) return false;
        if (FK_Users != ad.FK_Users) return false;
        if (Name != null ? !Name.equals(ad.Name) : ad.Name != null) return false;
        if (Genre != null ? !Genre.equals(ad.Genre) : ad.Genre != null) return false;
        return Description != null ? Description.equals(ad.Description) : ad.Description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Genre != null ? Genre.hashCode() : 0);
        result = 31 * result + Number_Of_Players;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        result = 31 * result + FK_Users;
        return result;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Number_Of_Players=" + Number_Of_Players +
                ", price=" + price +
                ", Description='" + Description + '\'' +
                ", FK_Users=" + FK_Users +
                '}';
    }
}
