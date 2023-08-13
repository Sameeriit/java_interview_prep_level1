package StackAndQueue;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


//
//        1. You are given a number n, representing the number of time-intervals.
//        2. In the next n lines, you are given aPair of space separated numbers.
//        3. ThePair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
//        4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.
//
//        E.g. Let us say there are 6 meetings
//        1 8
//        5 12
//        14 19
//        22 28
//        25 27
//        27 30
//
//        Then the output of merged meetings will belong
//        1 12
//        14 19
//        22 30
//
//        Note -> The given input may not be sorted by start-time.

/**
 * solved
 * Author: Sameer Ahmad
 * date: 3/4/2023
 */

public class MergeOverlappingInterval {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]arr = new int[n][2];

        for(int j = 0; j < n; j++){
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }
        mergeOverlappingInterval(arr);

    }
    public static void mergeOverlappingInterval(int[][] arr){
       Pair[] pairs = new Pair[arr.length];
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs); // here we sort the pairs of time interval

        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < pairs.length; i++){
            if(i == 0){
                st.push(pairs[i]);
            }else{
                Pair top = st.peek();
                if(pairs[i].st > top.et){
                    st.push(pairs[i]);
                }else{
                    top.et = Math.max(pairs[i].et, top.et);
                }
            }
        }
        // rs-> reverse stack
        Stack<Pair> rs = new Stack<>();
        while(st.size() > 0) {
            rs.push(st.pop());
        }
        while(rs.size() > 0){
            Pair p = rs.pop();
            System.out.println(p.st +" "+ p.et);
        }

    }
    public static  class Pair implements Comparable<Pair> {
        int st; // Start Time
        int et; // End Time
        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        public  int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st;
            }else{
                return this.et - other.et;
            }
        }
    }
}
