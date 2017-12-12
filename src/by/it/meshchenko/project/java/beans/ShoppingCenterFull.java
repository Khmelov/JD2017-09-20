package by.it.meshchenko.project.java.beans;

public class ShoppingCenterFull {

    private ShoppingCenter shoppingCenter;
    private Country country;
    private City city;
    private Street street;
    private Address address;

    public ShoppingCenterFull() {}

    public ShoppingCenterFull(ShoppingCenter shoppingCenter, Country country, City city, Street street, Address address) {
        this.shoppingCenter = shoppingCenter;
        this.country = country;
        this.city = city;
        this.street = street;
        this.address = address;
    }

    public ShoppingCenter getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenter shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCenterFull that = (ShoppingCenterFull) o;

        if (shoppingCenter != null ? !shoppingCenter.equals(that.shoppingCenter) : that.shoppingCenter != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = shoppingCenter != null ? shoppingCenter.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingCenterFull{" +
                "shoppingCenter=" + shoppingCenter +
                ", country=" + country +
                ", city=" + city +
                ", street=" + street +
                ", address=" + address +
                '}';
    }
}
