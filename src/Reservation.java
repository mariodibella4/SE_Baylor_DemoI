import java.util.ArrayList;
import java.util.Arrays;

public class Reservation {


    private String checkIn;
    private String checkOut;
    private String bedType;
    private int res_ID;
    private int numberOfRooms;
    private int numberOfGuests;
    private String firstName;
    private String lastName;
    private static int MAX_KING=80;
    private static int MAX_DBL_QUEEN=20;
    private String CC;
    private String exp;
    private int CRV;

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    private static ArrayList<Reservation> reservations=new ArrayList<>();
    public Reservation(int res_ID,String checkin, String checkout,String firstName,
                       String lastName, int numberOfGuests,int numberOfRooms, String bedType,
                       String CC,String exp,int CRV){
        this.res_ID=res_ID;
        this.checkIn=checkin;
        this.checkOut=checkout;
        this.numberOfGuests=numberOfGuests;
        this.numberOfRooms=numberOfRooms;
        this.bedType=bedType;
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
