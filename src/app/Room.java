package app;

import java.util.ArrayList;
import app.descriptors.*;
public class Room {

    private char available;

    public int getQuality() {
        return quality;
    }

    public int getCurrentRate() {
        return currentRate;
    }

    public float getMaxRate() {
        return maxRate;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public String getBedType() {
        return bedType;
    }

    public char getSmoking() {
        return smoking;
    }

    public int getMAX_ROOMS() {
        return MAX_ROOMS;
    }

    private int quality;
    private int currentRate;
    private int maxRate;
    private int numberOfBeds;
    private String bedType;
    private char smoking;

    public String getGeneralDescription() {
        return generalDescription;
    }

    private String generalDescription;
    private final int MAX_ROOMS=100;
    private static ArrayList<Room> rooms=new ArrayList<>();

    public Room(char available, RoomQuality roomQuality, RoomDescription roomDescription){

        this.available=available;
        this.quality=roomQuality.getQualityLevel();
        this.maxRate=roomQuality.getMaxRate();
        this.currentRate=roomDescription.getCurrentPrice();
        this.numberOfBeds=roomDescription.getNumberOfBeds();
        this.bedType=roomDescription.getBedType();
        this.smoking= roomDescription.getSmoking();
        this.generalDescription=roomDescription.getGeneralDescription();
    }
    public char getAvailable() {
        return available;
    }
    public void setAvailable(char available) {
        this.available = available;
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }
}
