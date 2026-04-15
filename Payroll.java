class Emp {
    int id; String name; double sal;
    Emp(int i,String n,double s){id=i;name=n;sal=s;}

    double net(){
        double tax = sal > 50000 ? sal*0.2 : sal*0.1;
        return sal - tax + 2000;
    }
}

public class Payroll {
    public static void main(String[] args){
        Emp e = new Emp(1,"A",60000);
        System.out.println(e.net());
    }
}