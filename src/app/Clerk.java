package app;

import java.util.ArrayList;

public class Clerk
{
    private String firstName, lastName, email;
    private char[] password;
    private int clerkID;
    private static ArrayList<Clerk> registeredClerks = new ArrayList<Clerk>();

    public Clerk(String firstName, String lastName, String email, char[] password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.clerkID = registeredClerks.size() +1;
    }

    public static void addRegisteredClerk(Clerk c){
        registeredClerks.add(c);
    }

    public static ArrayList<Clerk> getRegisteredClerks() {return registeredClerks; }
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
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getClerkID() { return clerkID; }
}
