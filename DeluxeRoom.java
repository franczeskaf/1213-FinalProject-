// I created a class called DeluxeRoom which extends the abstract class Room, representing a deluxe room in the hotel
class DeluxeRoom extends Room {
    // I declared a constant to represent the cost of a deluxe room
    private static final double DELUXE_ROOM_COST = 200.0;

    // I created a constructor to initialize a deluxe room with a given room number
    public DeluxeRoom(int roomNumber) {
        // I called the constructor of the superclass (Room) with the provided room number
        super(roomNumber);
    }

    // I overrode the getCost method to return the cost of a deluxe room
    @Override
    public double getCost() {
        return DELUXE_ROOM_COST;
    }
}
