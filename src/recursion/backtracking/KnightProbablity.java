package recursion.backtracking;
/**
 * leetcode problem  Knight probablity
 * solution
 * Author : Sameer Ahmad
 * date : 17/10/2022
 */

import java.util.HashMap;

public class KnightProbablity {
    HashMap<String,Double> hm ;

    public  double knightprobablity(int N,int k, int r,int c ){
         hm = new HashMap();

         double result = prob(N,k,r,c)/Math.pow(8,k);
         return result;


    }
    public double prob(int n , int k,int r,int c){
        if(r <0 && r>= n && c<0 && c>=n){
            return 0;
        }
        String Key = k +"->"+r+"->"+c;
        //if path is not out of the board and no moves left return 1;
        if(k == 0){
            return 1;
        }
        if(hm.containsKey(Key)) return hm.get(Key);

        // There are total of 8 possible moves and we are traversing all the possible paths.
        double op1 = prob(n,k-1,r-2,c+1);
        double op2 = prob(n,k-1,r-1,c+2);
        double op3 = prob(n,k-1,r+1,c+2);
        double op4 = prob(n,k-1,r+2,c+1);
        double op5 = prob(n,k-1,r+2,c-1);
        double op6 = prob(n,k-1,r+1,c-2);
        double op7 = prob(n,k-1,r-1,c-2);
        double op8 = prob(n,k-1,r-2,c-1);

        double result = op1+op2+op3+op4+op5+op6+op7+op8;
        hm.put(Key,result);
        return result ;

    }


}
