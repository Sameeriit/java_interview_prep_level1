package recursion.WayUp;
import java.util.*;

/**
 * Problem print keypad code with recursion way up technique
 * solution
 * Author : Sameer Ahmad
 * date : 13/06/2022
 */
public class PrintSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.next();
//        String ans = sc.next();
         printSS(str,"");
    }

    public static void printSS(String ques,String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String ros  = ques.substring(1);

        printSS(ros, ans +ch);
        printSS(ros,ans +"");


    }

}