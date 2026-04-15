import java.util.*;

class Bus {
    int busId;
    int totalSeats;
    boolean[] seats;

    Bus(int busId, int totalSeats) {
        this.busId = busId;
        this.totalSeats = totalSeats;
        seats = new boolean[totalSeats]; // false = available
    }

    void displaySeats() {
        System.out.println("Bus ID: " + busId);
        for (int i = 0; i < totalSeats; i++) {
            System.out.println("Seat " + (i + 1) + " : " + (seats[i] ? "Booked" : "Available"));
        }
    }

    void bookSeat(int seatNo) {
        if (seatNo < 1 || seatNo > totalSeats) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (seats[seatNo - 1]) {
            System.out.println("Seat already booked!");
        } else {
            seats[seatNo - 1] = true;
            System.out.println("Seat booked successfully!");
        }
    }

    void cancelSeat(int seatNo) {
        if (seatNo < 1 || seatNo > totalSeats) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (!seats[seatNo - 1]) {
            System.out.println("Seat already available!");
        } else {
            seats[seatNo - 1] = false;
            System.out.println("Booking cancelled!");
        }
    }
}

public class bus {
    static Scanner sc = new Scanner(System.in);
    static List<Bus> buses = new ArrayList<>();

    public static void main(String[] args) {
        buses.add(new Bus(101, 5));
        buses.add(new Bus(102, 5));

        while (true) {
            System.out.println("\n===== BUS RESERVATION SYSTEM =====");
            System.out.println("1. View Buses");
            System.out.println("2. View Seats");
            System.out.println("3. Book Seat");
            System.out.println("4. Cancel Seat");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewBuses();
                    break;

                case 2:
                    Bus bus1 = getBus();
                    if (bus1 != null) bus1.displaySeats();
                    break;

                case 3:
                    Bus bus2 = getBus();
                    if (bus2 != null) {
                        System.out.print("Enter seat number: ");
                        int seat = sc.nextInt();
                        bus2.bookSeat(seat);
                    }
                    break;

                case 4:
                    Bus bus3 = getBus();
                    if (bus3 != null) {
                        System.out.print("Enter seat number: ");
                        int seat = sc.nextInt();
                        bus3.cancelSeat(seat);
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void viewBuses() {
        System.out.println("Available Buses:");
        for (Bus b : buses) {
            System.out.println("Bus ID: " + b.busId + " | Seats: " + b.totalSeats);
        }
    }

    static Bus getBus() {
        System.out.print("Enter Bus ID: ");
        int id = sc.nextInt();

        for (Bus b : buses) {
            if (b.busId == id) {
                return b;
            }
        }

        System.out.println("Bus not found!");
        return null;
    }
}