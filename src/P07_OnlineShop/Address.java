package P07_OnlineShop;

public class Address {
    private String name;
    private String city;
    private String street;
    private int number;

    public Address(String name, String city, String street, int number) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}