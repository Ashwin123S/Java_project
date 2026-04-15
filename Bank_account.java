import java.util.*;

class Account {
    int accNo;
    String name;
    double bal;

    Account(int a, String n, double b) {
        accNo = a; name = n; bal = b;
    }
}

public class Bank_account {
    static List<Account> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Create 2.Deposit 3.Withdraw 4.Transfer 5.View");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> list.add(new Account(sc.nextInt(), sc.next(), sc.nextDouble()));
                case 2 -> op(1);
                case 3 -> op(2);
                case 4 -> transfer();
                case 5 -> list.forEach(a -> System.out.println(a.accNo + " " + a.bal));
            }
        }
    }

    static Account find(int id) {
        return list.stream().filter(a -> a.accNo == id).findFirst().orElse(null);
    }

    static void op(int type) {
        int id = sc.nextInt();
        double amt = sc.nextDouble();
        Account a = find(id);
        if (a != null) {
            if (type == 1) a.bal += amt;
            else if (a.bal >= amt) a.bal -= amt;
        }
    }

    static void transfer() {
        int f = sc.nextInt(), t = sc.nextInt();
        double amt = sc.nextDouble();
        Account a = find(f), b = find(t);
        if (a != null && b != null && a.bal >= amt) {
            a.bal -= amt;
            b.bal += amt;
        }
    }
}