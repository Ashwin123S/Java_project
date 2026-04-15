import java.util.*;
class Student {
    int id;
    String name;
    double[] marks;
    Student(int id, String name, double[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    double avg() {
        double sum = 0;
        for (double m : marks) sum += m;
        return sum / marks.length;
    }
    char grade() {
        double a = avg();
        if (a >= 90) return 'A';
        if (a >= 75) return 'B';
        if (a >= 50) return 'C';
        return 'F';
    }
}
public class Students {
    static List<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Add 2.Display 3.Search 4.Delete 5.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> add();
                case 2 -> display();
                case 3 -> search();
                case 4 -> delete();
                case 5 -> System.exit(0);
            }
        }
    }
    static void add() {
        System.out.print("ID Name Marks(3): ");
        int id = sc.nextInt();
        String name = sc.next();
        double[] m = {sc.nextDouble(), sc.nextDouble(), sc.nextDouble()};
        list.add(new Student(id, name, m));
    }
    static void display() {
        for (Student s : list)
            System.out.println(s.id + " " + s.name + " Avg:" + s.avg() + " Grade:" + s.grade());
    }
    static void search() {
        int id = sc.nextInt();
        for (Student s : list)
            if (s.id == id) System.out.println(s.name);
    }
    static void delete() {
        int id = sc.nextInt();
        list.removeIf(s -> s.id == id);
    }
}