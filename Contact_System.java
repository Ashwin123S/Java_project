import java.io.*;
import java.util.*;

public class Contact_System {
    public static void main(String[] args) throws Exception{
        FileWriter fw=new FileWriter("c.txt",true);
        fw.write("John\n"); fw.close();

        Scanner sc=new Scanner(new File("c.txt"));
        while(sc.hasNext()) System.out.println(sc.nextLine());
    }
}