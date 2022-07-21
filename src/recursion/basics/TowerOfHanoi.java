package recursion.basics;
import java.io.*;
import java.util.*;

/**
 * problem tower of hanoi
 * solution
 * Author : Sameer Ahmad
 * date : 8/06/2022
 */

public class TowerOfHanoi {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();
        Toh(n,t1,t2,t3);

    }
    public static void Toh(int n, int t1id, int t2id, int t3id){

        if(n == 0){
            return;
        }

        Toh(n-1, t1id,t3id,t2id);
        System.out.println(n +"[" + t1id + " -> " + t2id +"]");
        Toh(n-1, t3id,t2id,t1id);
    }
}
