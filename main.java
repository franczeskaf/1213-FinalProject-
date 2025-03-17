// I imported the java.util package to utilize the Scanner class and other utilities
import java.util.*;

// I created the main class to handle hotel reservation system functionality
public class Main {
    public static void main(String[] args) {
        // I instantiated the HotelReservation class to manage hotel operations
        HotelReservation hotel = new HotelReservation();
        // I initialized a Scanner object to capture user input from the console
        Scanner scanner = new Scanner(System.in);
        // I set up a variable to control the loop
        int count = 0;

        // I initiated the main loop of the program
        while (count >= 0) {
            // I printed a welcome message and presented options for the user
            System.out.println("\nWelcome to Our Hotel Reservation System");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Calculate Total Cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            // I obtained user input for their choice
            int choice = scanner.nextInt();

            // I utilized a switch statement to handle user choices
            switch (choice) {
                case 1:
                    // I called the method to display available rooms
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    // I prompted the user for the room number to book and invoked the method to book the room
                    System.out.print("Enter the room number you want to book: ");
                    int roomNumber = scanner.nextInt();
                    hotel.bookRoom(roomNumber);
                    break;
                case 3:
                    // I calculated and displayed the total cost of occupied rooms
                    double totalCost = hotel.calculateTotalCost();
                    System.out.println("Total Cost of Occupied Rooms: $" + totalCost);
                    break;
                case 4:
                    // I saved room information to a file and exited the loop
                    hotel.saveRoomsToFile();
                    System.out.println("Thank you for using our Hotel Reservation System.");
                    count = -1; // Exiting the loop
                    break;
                default:
                    // I handled an invalid choice by informing the user to try again
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        // I closed the Scanner object to release resources
        scanner.close();
    }
}
