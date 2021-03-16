public class RoomDescription {

    private float currentPrice;
    private int numberOfBeds;
    private String bedType;
    private char smoking;

    public RoomDescription(int currentPrice, int numberOfBeds, String bedType, char smoking) {
        this.currentPrice = currentPrice;
        this.numberOfBeds = numberOfBeds;
        this.bedType = bedType;
        this.smoking = smoking;
    }
    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public char getSmoking() {
        return smoking;
    }

    public void setSmoking(char smoking) {
        this.smoking = smoking;
    }
}
