import java.util.*;

public class PasswordStrength {
    public static void main(String[] args){
        String p=new Scanner(System.in).next();
        int score=0;
        if(p.length()>=8) score++;
        if(p.matches(".*[A-Z].*")) score++;
        if(p.matches(".*[0-9].*")) score++;

        System.out.println(score>=3?"Strong":score==2?"Medium":"Weak");
    }
}