import java.util.*;

public class Vote {
    static Set<Integer> voted=new HashSet<>();
    static int count=0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        if(!voted.contains(id)){
            voted.add(id);
            count++;
        }
        System.out.println(count);
    }
}