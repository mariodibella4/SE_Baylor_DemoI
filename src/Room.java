public class Room {

    private int room_id;
    private char available;
    private int quality;
    private float currentRate;
    private float maxRate;
    private int numberOfBeds;
    private String bedType;
    private char smoking;
    private final int MAX_ROOMS=100;
    private Room(int room_id,char available,RoomQuality roomQuality,RoomDescription roomDescription){
        this.room_id=room_id;
        this.available=available;
        this.quality=roomQuality.getQualityLevel();
        this.maxRate=roomQuality.getMaxRate();
        this.currentRate=roomDescription.getCurrentPrice();
        this.numberOfBeds=roomDescription.getNumberOfBeds();
        this.bedType=roomDescription.getBedType();
        this.smoking= roomDescription.getSmoking();
    }
    public int getRoom_id() {
        return room_id;
    }
    public char getAvailable() {
        return available;
    }
    public void setAvailable(char available) {
        this.available = available;
    }
}
