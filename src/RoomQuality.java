public class RoomQuality {

    private int qualityLevel;
    private float maxRate;

    private RoomQuality(int qualityLevel, int maxRate) {
        this.qualityLevel = qualityLevel;
        this.maxRate = maxRate;
    }
    public static RoomQuality levelOne(int maxRate){
        return new RoomQuality(1,maxRate);
    }
    public static RoomQuality levelTwo(int maxRate){
        return new RoomQuality(2,maxRate);
    }
    public static RoomQuality levelThree(int maxRate){
        return new RoomQuality(3,maxRate);
    }

    public int getQualityLevel() {
        return qualityLevel;
    }

    public void setQualityLevel(int qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public float getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(int maxRate) {
        this.maxRate = maxRate;
    }
}
