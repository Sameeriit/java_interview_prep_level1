package com.sameer;
import java.io.*;
import java.util.*;

public class anyBaseSubstraction{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2){
        // write your code here

        int rv = 0;

        int c = 0;

        int p = 1;

        while( n2 > 0){   // n2 is bigger number there for n2 is sufficieant

            int d1 = n1 % 10;
            int d2 = n2 % 10;

            int d = 0;
            d2 = d2 + c;  //after substracting managing the previous carry

            if( d2 >= d1){
                c = 0;
                d = d2 - d1;
            }else{
                c = -1;
                d = (d2 + b ) - d1; // when carry is taken it means base is added

            }
            rv += d * p;
            p = p * 10;

            n1 /= 10;
            n2 /= 10;

        }

        return rv;
    }

}
