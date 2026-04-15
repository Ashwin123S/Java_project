import java.util.*;

public class ATM {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int pin=1234, bal=10000;
        int p=sc.nextInt();
        if(p==pin){
            int ch=sc.nextInt();
            if(ch==1) System.out.println(bal);
            else if(ch==2) bal+=sc.nextInt();
            else if(ch==3){
                int w=sc.nextInt();
                if(bal>=w) bal-=w;
            }
        }
    }
}