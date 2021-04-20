package app;

import java.util.ArrayList;

public class Reservation {


    private String checkIn;
    private String checkOut;
    private String[] bedType;
    private int res_ID;
    private int numberOfRooms;
    private int numberOfGuests;

    public void setCC(String CC) {
        this.CC = CC;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void setCRV(int CRV) {
        this.CRV = CRV;
    }

    private String firstName;
    private String lastName;
    private static int MAX_KING=80;
    private static int MAX_DBL_QUEEN=20;
    private String CC;
    private String exp;
    private int CRV;
    private int[] quality;
    private char[] smoking;
    private String email;
    private String streetAddr;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddr() {
        return streetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        this.streetAddr = streetAddr;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    private String city;
    private  String country;
    private String zipcode;

    public int getGuestID() {
        return guestID;
    }

    private int guestID;
    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    private static ArrayList<Reservation> reservations=new ArrayList<>();
    public Reservation(int guestID,int res_ID,String checkin, String checkout,String firstName,
                       String lastName, int numberOfGuests, Room[] room, String email,
                       String streetAddr, String city, String country, String zipcode,
                       String CC,String exp,int CRV){
        this.guestID=guestID;
        this.res_ID=res_ID;
        this.checkIn=checkin;
        this.checkOut=checkout;
        this.numberOfGuests=numberOfGuests;
        this.numberOfRooms=room.length;
        this.bedType=new String[room.length];
        this.quality=new int[room.length];
        this.smoking=new char[room.length];
        for(int i=0;i<room.length;i++)
                this.bedType[i]=room[i].getBedType();
        for(int i=0;i<room.length;i++)
            this.quality[i]=room[i].getQuality();
        for(int i=0;i<room.length;i++)
            this.smoking[i]=room[i].getSmoking();

        this.firstName=firstName;
        this.lastName=lastName;
        this.CC=CC;
        this.exp=exp;
        this.CRV=CRV;
    }
    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getRes_ID() {
        return res_ID;
    }

    public void setRes_ID(int res_ID) {
        this.res_ID = res_ID;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int kingBooked(){
        return --MAX_KING;
    }
    public int doubleQueenBooked(){
        return --MAX_DBL_QUEEN;
    }
    public int kingReleased(){
        return ++MAX_KING;
    }
    public int doubleQueenReleased(){
        return ++MAX_DBL_QUEEN;
    }
    public static int getMaxKing() {
        return MAX_KING;
    }
    public static int getMaxDblQueen() {
        return MAX_DBL_QUEEN;
    }


}
