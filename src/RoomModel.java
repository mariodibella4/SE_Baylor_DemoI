import java.util.ArrayList;

public class RoomModel {
    public static ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }

    private static ArrayList<Room> availableRooms=new ArrayList<>();
    public static void retrieveAvailableRooms(String checkin,String checkout){
        availableRooms.add(new Room('Y',
                            RoomQuality.levelFive(1799),
                            new RoomDescription(1099,1,"King",'N',"3 room Suite With gorgeous views and a butler")));
        availableRooms.add(new Room('Y',
                RoomQuality.levelFour(999),
                new RoomDescription(799,1,"King",'N',"Studio With gorgeous views and luxury pullout couch")));
        availableRooms.add(new Room('Y',
                RoomQuality.levelThree(699),
                new RoomDescription(599,1,"King",'N',"Studio With gorgeous views")));
        availableRooms.add(new Room('Y',
                RoomQuality.levelStandard(499),
                new RoomDescription(449,1,"King",'N',"With gorgeous views")));
        availableRooms.add(new Room('Y',
                RoomQuality.levelStandard(499),
                new RoomDescription(449,1,"King",'Y',"With gorgeous views")));
        availableRooms.add(new Room('Y',
                RoomQuality.levelStandard(899),
                new RoomDescription(699,1,"Two Queen",'N',"Studio With gorgeous views and Playstation")));
        availableRooms.add(new Room('Y',
                RoomQuality.levelStandard(899),
                new RoomDescription(699,1,"Two Queen",'N',"Studio With gorgeous views and Playstation")));
    }
}
