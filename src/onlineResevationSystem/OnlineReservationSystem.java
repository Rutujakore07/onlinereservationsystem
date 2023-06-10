package onlineResevationSystem;

import java.util.Scanner;

public class OnlineReservationSystem {

    private static boolean[] seats = new boolean[20]; // initialize an array of 20 seats, all empty
	private static Scanner scanner;
	private static Scanner scanner2;
	private static Scanner scanner3;

    public static void main(String[] args) {

        scanner3 = new Scanner(System.in);

        while (true) {

            // display menu
            System.out.println("\nPlease choose the option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // get user input
            int option = scanner3.nextInt();

            switch (option) {

                case 1:
                    viewSeatMap();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

       // seat arrangement map
    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print an "X" if the seat is reserved
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
        }
        System.out.println();
    }

    //reservation of seat 
    private static void reserveSeat() {
        scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-20): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 20) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }
    
    // cancelation of seat
    private static void cancelReservation() {
        scanner2 = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-20): ");
        int seatNumber = scanner2.nextInt();
        if (seatNumber < 1 || seatNumber > 20) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // Unreserved the seat
            System.out.println("Reservation canceled!");
        }
    }
}
 