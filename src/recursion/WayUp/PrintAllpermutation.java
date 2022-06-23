package recursion.WayUp;
import java.util.*;

public class PrintAllpermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        printPermutations(str,"");

    }

    public static void printPermutations(String str , String asf ){

        if(str.length() == 0){
            System.out.print(asf +" ");
            return;
        }


        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String qlpart = str.substring(0,i);
            String qrpart = str.substring(i+1);
            String ros = qlpart + qrpart;
            printPermutations(ros, asf + ch);
        }
    }
}
