import java.util.*;
class Product {
    int id, qty;
    String name;
    double price;
}
public class Inventory {
    static List<Product> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            int ch = sc.nextInt();
            if (ch == 1) {
                Product p = new Product();
                p.id=sc.nextInt(); p.name=sc.next();
                p.qty=sc.nextInt(); p.price=sc.nextDouble();
                list.add(p);
            } else {
                list.forEach(p -> System.out.println(p.name+" "+p.qty));
            }
        }
    }
}