import java.util.*;

class Room {
    int no; boolean booked;
}

public class Hotel {
    static List<Room> list = new ArrayList<>();
    static {
        for(int i=1;i<=5;i++){ Room r=new Room(); r.no=i; list.add(r); }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int no=sc.nextInt();
        for(Room r:list)
            if(r.no==no && !r.booked) r.booked=true;
    }
}