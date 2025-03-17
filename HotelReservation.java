// I imported the java.util package to use ArrayList and Scanner classes, and the java.io package for file operations

// Class for managing hotel operations
import java.util.*;
import java.io.*;
public class HotelReservation {
    // I declared a private ArrayList to store room objects
    private ArrayList<Room> rooms;

    // I created a constructor to initialize the ArrayList and load room information from a file
    public HotelReservation() {
        this.rooms = new ArrayList<>();
        loadRoomsFromFile();
    }

    // Method to load room information from a file
    private void loadRoomsFromFile() {
        try {
            // I created a File object to represent the roomList.txt file
            File roomFile = new File("roomList.txt");
            // I created a Scanner object to read data from the file
            Scanner scanner = new Scanner(roomFile);

            // I iterated through each line in the file
            while (scanner.hasNextLine()) {
                // I read each line and split it into room number and room type
                String line = scanner.nextLine();
                String[] roomInfo = line.split(",");
                int roomNumber = Integer.parseInt(roomInfo[0]);
                String roomType = roomInfo[1];

                // I checked the room type and created the appropriate room object
                if (roomType.equals("Standard")) {
                    rooms.add(new StandardRoom(roomNumber));
                } else if (roomType.equals("Deluxe")) {
                    rooms.add(new DeluxeRoom(roomNumber));
                }
            }
            // I closed the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            // I handled the FileNotFoundException by printing an error message
            System.out.println("Room file not found.");
        }
    }

    // Method to display available rooms
    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        // I iterated through each room in the ArrayList
        for (Room room : rooms) {
            // I checked if the room is not occupied and printed its information
            if (!room.isOccupied()) {
                System.out.println(room);
            }
        }
    }

    // Method to book a room
    public void bookRoom(int roomNumber) {
        // I iterated through each room in the ArrayList
        for (Room room : rooms) {
            // I checked if the room number matches and the room is not occupied
            if (room.getRoomNumber() == roomNumber && !room.isOccupied()) {
                // I occupied the room and printed a booking confirmation message
                room.occupyRoom();
                System.out.println("Room " + roomNumber + " has been booked.");
                return;
            }
        }
        // I printed a message if the room is not available for booking
        System.out.println("Room " + roomNumber + " is not available for booking.");
    }

    // Method to calculate the total cost of occupied rooms
    public double calculateTotalCost() {
        double totalCost = 0.0;
        // I iterated through each room in the ArrayList
        for (Room room : rooms) {
            // I checked if the room is occupied and added its cost to the total cost
            if (room.isOccupied()) {
                totalCost += room.getCost();
            }
        }
        // I returned the total cost
        return totalCost;
    }

    // Method to save room information to a file
    public void saveRoomsToFile() {
        try {
            // I created a FileWriter object to write data to the roomList.txt file
            FileWriter writer = new FileWriter("roomList.txt");
            // I iterated through each room in the ArrayList
            for (Room room : rooms) {
                // I determined the room type and wrote the room number and type to the file
                String roomType = room instanceof StandardRoom ? "Standard" : "Deluxe";
                writer.write(room.getRoomNumber() + "," + roomType + "\n");
            }
            // I closed the FileWriter
            writer.close();
        } catch (IOException e) {
            // I handled the IOException by printing an error message
            System.out.println("Error occurred while saving room information.");
        }
    }
}
