import java.util.*;

class Book {
    int id;
    String title;
    boolean issued;

    Book(int i, String t) { id = i; title = t; }
}

public class Library {
    static List<Book> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Add 2.Issue 3.Return 4.Display");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> list.add(new Book(sc.nextInt(), sc.next()));
                case 2 -> change(true);
                case 3 -> change(false);
                case 4 -> list.forEach(b -> System.out.println(b.title + " " + b.issued));
            }
        }
    }

    static void change(boolean issue) {
        int id = sc.nextInt();
        for (Book b : list)
            if (b.id == id && b.issued != issue) b.issued = issue;
    }
}