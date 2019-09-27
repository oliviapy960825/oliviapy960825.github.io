package week4;

public class FourRoomHouse {
    private Room one;
    private Room two;
    private Room three;
    private Room four;
    
    public FourRoomHouse(Room one, Room two, Room three, Room four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public static FourRoomHouse dannysHouse() {
        return new FourRoomHouse(
            new Kitchen(10, 8), 
            new Kitchen(20, 25), 
            new Bathroom(10, 10), 
            new Bedroom(20, 20));
    }
    
    public static FourRoomHouse dorm() {
        return new FourRoomHouse(
            new Bedroom(8, 8),
            new Bedroom(8, 8),
            new Bedroom(8, 8),
            new Bedroom(8, 8));
    }
}
