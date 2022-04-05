package StringAndStringbuilder;
import java.io.*;
import java.util.Scanner;

/** PRIBLEM ON STRING COMPRESSION
 * YOU are given a string
 * you have to compress the given string
 */





public class String_compression {

    public static String compression1(String str){
        String s = str.charAt(0) +"";
        for(int i = 1; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr != prev){
                s +=curr;
            }
        }
        return s;
    }


    public static String compression2(String str){
        String s = str.charAt(0)+"";
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

             if(curr == prev){
                 count++;

             }else {
                 if (count > 1) {
                     s += count;
                     count = 1;
                 }
                 s += curr;
             }

        }
        if(count > 1){
            s +=count;
            count =1;
        }

        return s;

    }







    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));















////        StringBuilder sb = new StringBuilder("hello");
////        System.out.println(sb);
////
////
////        char ch = sb.charAt(0);
////        System.out.println(ch);
////
////        sb.setCharAt(0,'d');
////        System.out.println(sb);
//        /**
//        String str = "hello";
//        System.out.println(str);
//        char ch = str.charAt(3);
//        System.out.println(ch); */
//
//        int num = 100000;
//        long start = System.currentTimeMillis();
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < num; i++){
//            sb.append(i);
//        }
////        String s = "";
////        for(int i = 0 ; i < num; i++){
////            s += i;
////        }
//        long end = System.currentTimeMillis();
//        long duration = end - start;
//        System.out.println(duration);


    }
}
