package recursion.WayUp;
import java.util.*;

/**
 * problem printStairPath using way up technique
 * solution
 * Author : Sameer Ahmad
 * date: 18/06/2022
 */

public class PrintStairPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        print_stair_path(n,"");



    }
    public static void print_stair_path(int n, String path){
        if(n < 0){
            return;
        }
        if(n == 0){
            System.out.println(path);
            return;
        }


        print_stair_path(n-1,path + "1");
        print_stair_path(n-2,path + "2");
        print_stair_path(n-3,path + "3");

    }
}
