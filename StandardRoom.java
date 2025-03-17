// I created a class called StandardRoom which extends the abstract class Room, representing a standard room in the hotel
class StandardRoom extends Room {
    // I declared a constant to represent the cost of a standard room
    private static final double STANDARD_ROOM_COST = 100.0;

    // I created a constructor to initialize a standard room with a given room number
    public StandardRoom(int roomNumber) {
        // I called the constructor of the superclass (Room) with the provided room number
        super(roomNumber);
    }

    // I overrode the getCost method to return the cost of a standard room
    @Override
    public double getCost() {
        return STANDARD_ROOM_COST;
    }
}
