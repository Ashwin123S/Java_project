import java.util.*;

class Q {
    String q, a;
    String[] o;
    Q(String q, String[] o, String a) { this.q=q; this.o=o; this.a=a; }
}

public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Q> list = List.of(
            new Q("2+2?", new String[]{"3","4","5"}, "4")
        );

        int score = 0;
        for (Q x : list) {
            System.out.println(x.q);
            for (String op : x.o) System.out.println(op);
            if (sc.next().equals(x.a)) score++;
        }
        System.out.println("Score: " + score);
    }
}