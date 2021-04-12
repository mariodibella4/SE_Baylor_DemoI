package Servicers;

import app.Room;

import java.time.LocalDate;
import java.time.Month;
import  java.time.temporal.ChronoUnit;

public class ReservationTotalsCalculator {


    private int totalBeforeTax;
    private double totalAfterTax;
    private final double tax=0.10;

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    private double totalSalesTax;
    private final double serviceTax=0.08;
    private double totalServiceTax;
    private final double cityTax=0.0875;
    private double totalCityTax;
    private int numberOfNights;


    public ReservationTotalsCalculator(String checkin,String checkout,Room[] rooms){
        this.numberOfNights=calcNumberOfNights(checkin,checkout);
        this.totalBeforeTax=calcTotalBeforeTax(this.numberOfNights,rooms);
        this.totalSalesTax=calcTotalSalesTax(this.totalBeforeTax);
        this.totalServiceTax=calcTotalServiceTax(this.totalBeforeTax);
        this.totalCityTax=calctotalCityTax(this.totalBeforeTax);
        this.totalAfterTax=calctotalAfterTax(this.totalBeforeTax,this.totalSalesTax,this.totalServiceTax,this.totalCityTax);

    }
    private int calcNumberOfNights(String checkin,String checkout){
        String[] tokens= checkin.split("-");
        int monthNumber=Integer.parseInt(tokens[0]);
        Month.of(monthNumber).name();
        LocalDate dateBefore = LocalDate.of(Integer.parseInt(tokens[2]), Month.valueOf(Month.of(monthNumber).name()), Integer.parseInt(tokens[1]));
        String[] tokens1= checkout.split("-");
        int monthNumber1=Integer.parseInt(tokens1[0]);
        Month.of(monthNumber1).name();
        LocalDate dateAfter = LocalDate.of(Integer.parseInt(tokens1[2]), Month.valueOf(Month.of(monthNumber).name()), Integer.parseInt(tokens1[1]));
        return (int)ChronoUnit.DAYS.between(dateBefore, dateAfter);
    }
    private int calcTotalBeforeTax(int numberOfNights, Room[] rooms){
        int total=0;
        for(int i=0; i<rooms.length;i++){
            total+=numberOfNights*rooms[i].getCurrentRate();
        }
        return total;
    }
    private double calcTotalSalesTax(int totalBeforeTax){
        return tax*totalBeforeTax;
    }
    private double calcTotalServiceTax(int totalBeforeTax){
        return serviceTax*totalBeforeTax;
    }
    private double calctotalCityTax(int totalBeforeTax){
        return cityTax*totalBeforeTax;
    }
    private double calctotalAfterTax(int totalBeforeTax,double totalSalesTax,double totalServiceTax,double totalCityTax){
        return totalBeforeTax+totalCityTax+totalSalesTax+totalServiceTax;
    }
    public int getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public double getTotalAfterTax() {
        return totalAfterTax;
    }

    public double getTax() {
        return tax;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    public double getTotalServiceTax() {
        return totalServiceTax;
    }

    public double getCityTax() {
        return cityTax;
    }

    public double getTotalCityTax() {
        return totalCityTax;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }
}
