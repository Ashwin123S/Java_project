import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Coach {

    public static final int MAX_SEATS   = 60;
    public static final int MAX_WAITING = 10;

    private String coachType;
    private int    seatsBooked;        
    private List<Ticket>  confirmedList;  
    private Queue<Ticket> waitingList;    

    public Coach(String coachType) {
        this.coachType     = coachType;
        this.seatsBooked   = 0;
        this.confirmedList = new ArrayList<>();
        this.waitingList   = new LinkedList<>();
    }

    public String getCoachType()             { return coachType; }
    public int    getSeatsBooked()           { return seatsBooked; }
    public int    getWaitingCount()          { return waitingList.size(); }
    public List<Ticket>  getConfirmedList()  { return confirmedList; }
    public Queue<Ticket> getWaitingList()    { return waitingList; }


    public boolean hasConfirmedSeat() { return seatsBooked < MAX_SEATS; }
    public boolean hasWaitingSlot()   { return waitingList.size() < MAX_WAITING; }

  
    public Ticket book(String passengerName) {

        if (hasConfirmedSeat()) {
            seatsBooked++;
            Ticket t = new Ticket(passengerName, coachType, "CONFIRMED", seatsBooked);
            confirmedList.add(t);
            return t;

        } else if (hasWaitingSlot()) {
            Ticket t = new Ticket(passengerName, coachType, "WAITING", 0);
            waitingList.add(t);
            return t;

        } else {
            return null;
        }
    }
    public boolean cancel(int ticketId) {

        // 1. Search confirmed list
        Ticket toRemove = null;
        for (Ticket t : confirmedList) {
            if (t.getTicketId() == ticketId) {
                toRemove = t;
                break;
            }
        }

        if (toRemove != null) {
            int freedSeat = toRemove.getSeatNumber();
            confirmedList.remove(toRemove);
            seatsBooked--;
            if (!waitingList.isEmpty()) {
                Ticket promoted = waitingList.poll();
                promoted.setSeatStatus("CONFIRMED");
                promoted.setSeatNumber(freedSeat);
                confirmedList.add(promoted);
                seatsBooked++;
                System.out.println("\n  >> Waiting-list passenger promoted: " + promoted);
            }
            return true;
        }
        for (Ticket t : waitingList) {
            if (t.getTicketId() == ticketId) {
                waitingList.remove(t);
                return true;
            }
        }

        return false;   
    }
    public void printChart() {
        System.out.println("\n  Coach : " + coachType);
        System.out.println("  Total Seats    : " + MAX_SEATS);
        System.out.println("  Seats Booked   : " + seatsBooked);
        System.out.println("  Seats Available: " + (MAX_SEATS - seatsBooked));
        System.out.println("  Waiting List   : " + waitingList.size() + " / " + MAX_WAITING);
    }
}
