public class Ticket {
    private static int counter = 1000;   
    private int    ticketId;
    private String passengerName;
    private String coachType;    
    private String seatStatus;   
    private int    seatNumber;
    public Ticket(String passengerName, String coachType,
                  String seatStatus, int seatNumber) {
        this.ticketId      = ++counter;
        this.passengerName = passengerName;
        this.coachType     = coachType;
        this.seatStatus    = seatStatus;
        this.seatNumber    = seatNumber;
    }
    public int    getTicketId()      { return ticketId; }
    public String getPassengerName() { return passengerName; }
    public String getCoachType()     { return coachType; }
    public String getSeatStatus()    { return seatStatus; }
    public int    getSeatNumber()    { return seatNumber; }
    public void setSeatStatus(String seatStatus) { this.seatStatus = seatStatus; }
    public void setSeatNumber(int seatNumber)    { this.seatNumber = seatNumber; }
    @Override
    public String toString() {
        return "Ticket ID : " + ticketId
             + " | Name : "   + passengerName
             + " | Coach : "  + coachType
             + " | Status : " + seatStatus
             + " | Seat : "   + (seatNumber == 0 ? "WL" : seatNumber);
    }
}
