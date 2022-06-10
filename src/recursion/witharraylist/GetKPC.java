package recursion.witharraylist;
import java.util.*;

/**
 * problem getKPC -> KEY PAD CODE combination how many word can be possible
 * solution
 * Author : Sameer Ahmad
 * date : 10/06/2022
 */


public class GetKPC {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> result = getKPC(str);
        System.out.println(result);


    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};
    public static ArrayList<String> getKPC(String str){

        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");  // this is like balti me mug mug me pani nhi..!
            return bres;
        }

        //678
        char ch = str.charAt(0);   //6
        String ros = str.substring(1);  //78
        ArrayList<String> rres = getKPC(ros);

        ArrayList<String> mres =new ArrayList<>();
        String codeforch = codes[ch -'0'];
        for(int i = 0; i < codeforch.length(); i++ ) {  //all character of 6
            char codech = codeforch.charAt(i); // storing character here one by one apply cartision product
            for (String rstr : rres) {
                mres.add(codech + rstr);
            }
        }

        return mres;
    }
}
