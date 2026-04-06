import java.util.HashMap;
import java.util.Map;

public class ReservationSystem {
    private Map<String, Coach> coaches;
    public ReservationSystem() {
        coaches = new HashMap<>();
        coaches.put("AC",     new Coach("AC"));
        coaches.put("NON_AC", new Coach("NON_AC"));
        coaches.put("SEATER", new Coach("SEATER"));
    }
    public void bookTicket(String passengerName, String coachType) {

        Coach coach = getCoach(coachType);
        if (coach == null) return;

        Ticket t = coach.book(passengerName);

        if (t == null) {
            System.out.println("\n  BOOKING FAILED: Both confirmed seats and "
                             + "waiting list are full for " + coachType
                             + ". Request cancelled.");
        } else {
            System.out.println("\n  BOOKING SUCCESS: " + t);
        }
    }
    public void checkAvailability(String coachType) {

        Coach coach = getCoach(coachType);
        if (coach == null) return;

        System.out.println("\n  ---- Availability Check ----");
        coach.printChart();
    }
    public void cancelTicket(int ticketId) {

        boolean found = false;

        // Search across all coaches
        for (Coach coach : coaches.values()) {
            if (coach.cancel(ticketId)) {
                System.out.println("\n  CANCELLATION SUCCESS: Ticket " + ticketId + " cancelled.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\n  CANCELLATION FAILED: Ticket ID " + ticketId + " not found.");
        }
    }
    public void prepareChart() {

        System.out.println("\n  ========== RESERVATION CHART ==========");

        for (String type : new String[]{"AC", "NON_AC", "SEATER"}) {
            Coach coach = coaches.get(type);
            coach.printChart();

            System.out.println("\n  -- Confirmed Passengers --");
            if (coach.getConfirmedList().isEmpty()) {
                System.out.println("  (none)");
            } else {
                for (Ticket t : coach.getConfirmedList()) {
                    System.out.println("  " + t);
                }
            }

            System.out.println("\n  -- Waiting List --");
            if (coach.getWaitingList().isEmpty()) {
                System.out.println("  (none)");
            } else {
                for (Ticket t : coach.getWaitingList()) {
                    System.out.println("  " + t);
                }
            }
            System.out.println("  ----------------------------------------");
        }
    }
    public void checkStatus(int ticketId) {

        for (Coach coach : coaches.values()) {

            for (Ticket t : coach.getConfirmedList()) {
                if (t.getTicketId() == ticketId) {
                    System.out.println("\n  STATUS: " + t);
                    return;
                }
            }
            for (Ticket t : coach.getWaitingList()) {
                if (t.getTicketId() == ticketId) {
                    System.out.println("\n  STATUS: " + t);
                    return;
                }
            }
        }
        System.out.println("\n  STATUS: Ticket ID " + ticketId + " not found.");
    }
    private Coach getCoach(String coachType) {
        Coach coach = coaches.get(coachType.toUpperCase());
        if (coach == null) {
            System.out.println("  ERROR: Invalid coach type '" + coachType
                             + "'. Choose AC / NON_AC / SEATER.");
        }
        return coach;
    }
}
