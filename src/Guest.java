import java.util.ArrayList;

public class Guest {

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    private String lastName;
    private String email;
    private String street;
    private String city;
    private String country;
    private String zip;
    private char[] password;
    public static ArrayList<Guest> registeredGuests= new ArrayList<Guest>();
    public Guest(String firstName,String lastName, String email, String street, String city, String country, String zip,char[] password) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.email = email;
        this.street = street;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.password=password;
    }
    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
