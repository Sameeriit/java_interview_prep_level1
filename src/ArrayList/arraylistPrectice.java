package ArrayList;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * here we are just practicing arraylist..!
 */
public class arraylistPrectice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        ArrayList<Integer> ls = new ArrayList<>();
//        ls.add(10);
//        ls.add(20);
//        ls.add(30);
        ArrayList<Integer> ls = new ArrayList<>(); //Integer arraylist..!
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){  // adding arraylist by loop...!
            ls.add(sc.nextInt());
        }
        System.out.println(ls + "->" + ls.size());


        int value = ls.get(1);  //getting value from arraylist.
        System.out.println(value);

        ls.add(1,200); // adding function.
        System.out.println(ls + "->" + ls.size());


        ls.set(1,1000); //setting value on the  specific index.
        System.out.println(ls + "->" + ls.size());



        ls.remove(1); //remove from the arraylist
        System.out.println(ls + "->" + ls.size());

        System.out.println("------------------------------------------------------------------");
//        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<String> list = new ArrayList<>(); //string arraylist.
        for(int i = 0; i <num; i++){                // taking string from the user using loop;
            list.add(sc.next());
        }
        System.out.println(list);
        System.out.println(list + "->" + list.size());



    }
}
