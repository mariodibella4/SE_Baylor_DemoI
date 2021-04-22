package app;

import java.util.ArrayList;

public class Admin {
    private String firstName;
    private String lastName;
    private String email;
    private char[] password;
    private static ArrayList<Admin> registeredAdmins= new ArrayList<>();

    public Admin(String firstName, String lastName, String email, char[] password) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.email = email;
        this.password=password;
    }

    public Admin() {
        char[] password = new char[4];
        password[0] = 'r';
        password[1] = 'o';
        password[2] = 'o';
        password[3] = 't';
        this.password = password;
        this.firstName = "Super";
        this.lastName = "Admin";
        this.email = "superadmin@hotel.com";
    }

    public static ArrayList<Admin> getRegisteredAdmins() {
        return registeredAdmins;
    }
    public static void addRegisteredAdmin(Admin a) {
        registeredAdmins.add(a);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}

