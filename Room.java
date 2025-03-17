// I created an abstract class called Room to represent a room in the hotel
abstract class Room {
    // I declared private instance variables to store room information
    private int roomNumber;
    private boolean isOccupied;
    // I declared a static boolean variable and initialized it to false
    private static boolean no = false;

    // I created a constructor to initialize the room number and occupancy status
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        // I set the occupancy status using the static boolean variable
        this.isOccupied = no;
    }

    // I created getter method to retrieve the room number
    public int getRoomNumber() {
        return roomNumber;
    }

    // I created getter method to check if the room is occupied
    public boolean isOccupied() {
        return isOccupied;
    }

    // I created a method to mark the room as occupied
    public void occupyRoom() {
        this.isOccupied = true;
    }

    // I created a method to mark the room as vacant
    public void vacateRoom() {
        this.isOccupied = false;
    }

    // I declared an abstract method to get the cost of the room
    public abstract double getCost();

    // I overrode the toString method to provide a custom string representation of the room
    @Override
    public String toString() {
        // I used a ternary operator to display "Yes" if the room is occupied, and "No" otherwise
        return "Room Number: " + roomNumber + ", Occupied: " + (isOccupied ? "Yes" : "No");
    }
}
