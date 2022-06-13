package recursion.witharraylist;
import java.util.*;

/**
 * problem get stair path from the top to down example from n -> 0
 * solution
 * Author : Sameer Ahmad
 * date : 11/06/2022
 */

public class GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> result = getStairPaths(n);
        System.out.println(result);

    }
    public static ArrayList<String> getStairPaths(int n){

        if(n == 0 ){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        if(n < 0 ){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> paths1 = getStairPaths(n-1);
        ArrayList<String> paths2 = getStairPaths(n-2);
        ArrayList<String> paths3 = getStairPaths(n-3);
        ArrayList<String> paths = new ArrayList<>();


        for(String path : paths1){
            paths.add(1 +path);

        }
        for(String path : paths2){
            paths.add(2 + path);

        }
        for(String path : paths3){
            paths.add( 3 + path);

        }
        return paths;
    }
}
