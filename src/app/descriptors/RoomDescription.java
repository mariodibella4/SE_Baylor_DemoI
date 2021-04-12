package app.descriptors;

public class RoomDescription {

    private int currentPrice;
    private int numberOfBeds;
    private String bedType;
    private char smoking;

    public String getGeneralDescription() {
        return generalDescription;
    }

    private String generalDescription;

    public RoomDescription(int currentPrice, int numberOfBeds, String bedType, char smoking,String generalDescription) {
        this.currentPrice = currentPrice;
        this.numberOfBeds = numberOfBeds;
        this.bedType = bedType;
        this.smoking = smoking;
        this.generalDescription=generalDescription;
    }
    public int getCurrentPrice() {
        return currentPrice;
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

}
