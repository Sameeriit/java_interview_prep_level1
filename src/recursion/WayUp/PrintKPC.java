package recursion.WayUp;
import java.util.*;

public class PrintKPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        print_kpc(str,"");

    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void print_kpc(String ques, String ans){

        if(ques.length()== 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq  = ques.substring(1);

        String codeforch = codes[ch -'0']; // we get here "pqrs"and then we run loop over this string
        for(int i = 0; i < codeforch.length(); i++){
            char cho = codeforch.charAt(i);
            print_kpc(roq ,ans+ cho);
        }

    }
}
