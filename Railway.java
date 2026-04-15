import java.util.*;

public class Railway {
    static int seats=5;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        if(ch==1 && seats>0) seats--;
        else if(ch==2) seats++;
        System.out.println("Available: "+seats);
    }
}