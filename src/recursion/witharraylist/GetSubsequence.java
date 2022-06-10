package recursion.witharraylist;
import java.util.*;

/**
 * problem Get Subsequence of a string
 * solution
 * Author : Sameer Ahmad
 * date : 10/06/2022
 */

public class GetSubsequence {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> result = gss(str);
        System.out.println(result);
    }
    public static ArrayList<String> gss(String str){
        if(str.length() == 0){
         ArrayList<String> bres = new ArrayList<>();
         bres.add("");
         return bres;
        }
        //ALGORITHEM
        char fch = str.charAt(0);

        String ros = str.substring(1);

        ArrayList<String> rres = gss(ros);
        ArrayList<String> mres = new ArrayList<>();
        for(String rstr : rres) {
            mres.add("" + rstr);
        }

        for(String rstr : rres){
            mres.add(fch + rstr);

        }


        return mres;
    }

}
