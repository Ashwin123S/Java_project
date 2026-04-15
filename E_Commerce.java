import java.util.*;

public class E_Commerce  {
    public static void main(String[] args){
        List<Integer> cart=new ArrayList<>();
        cart.add(100); cart.add(200);
        int total=cart.stream().mapToInt(i->i).sum();
        System.out.println(total);
    }
}