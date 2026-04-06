import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ReservationSystem rs = new ReservationSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("    RAILWAY RESERVATION SYSTEM");
        System.out.println("=========================================");
        boolean running = true;
        while (running) {
            System.out.println("\n--------- MAIN MENU ---------");
            System.out.println("1. Book Ticket");
            System.out.println("2. Check Availability");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Prepare Full Chart");
            System.out.println("5. Check Ticket Status");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                // 1. BOOK
                case 1:
                    System.out.print("  Enter passenger name : ");
                    String name = sc.nextLine();

                    System.out.println("  Coach types: AC | NON_AC | SEATER");
                    System.out.print("  Enter coach type     : ");
                    String coach = sc.nextLine().toUpperCase();

                    rs.bookTicket(name, coach);
                    break;

                // 2. AVAILABILITY
                case 2:
                    System.out.println("  Coach types: AC | NON_AC | SEATER");
                    System.out.print("  Enter coach type: ");
                    String avCoach = sc.nextLine().toUpperCase();
                    rs.checkAvailability(avCoach);
                    break;

                // 3. CANCEL
                case 3:
                    System.out.print("  Enter Ticket ID to cancel: ");
                    int tid = sc.nextInt();
                    rs.cancelTicket(tid);
                    break;

                // 4. FULL CHART
                case 4:
                    rs.prepareChart();
                    break;

                //5. STATUS
                case 5:
                    System.out.print("  Enter Ticket ID: ");
                    int sid = sc.nextInt();
                    rs.checkStatus(sid);
                    break;

                // 6. EXIT
                case 6:
                    running = false;
                    System.out.println("\n  Thank you! Bye.");
                    break;

                default:
                    System.out.println("  Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
