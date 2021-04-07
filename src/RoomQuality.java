public class RoomQuality {

    private int qualityLevel;
    private int maxRate;

    private RoomQuality(int qualityLevel, int maxRate) {
        this.qualityLevel = qualityLevel;
        this.maxRate = maxRate;
    }
    public static RoomQuality levelStandard(int maxRate){
        return new RoomQuality(2,maxRate);
    }
    public static RoomQuality levelThree(int maxRate){
        return new RoomQuality(3,maxRate);
    }
    public static RoomQuality levelFour(int maxRate){
        return new RoomQuality(4,maxRate);
    }
    public static RoomQuality levelFive(int maxRate){
        return new RoomQuality(5,maxRate);
    }
    public int getQualityLevel() {
        return qualityLevel;
    }


    public int getMaxRate() {
        return maxRate;
    }

}
