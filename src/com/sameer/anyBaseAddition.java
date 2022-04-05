package com.sameer;

import java.util.Scanner;
public class anyBaseAddition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int b = sc.nextInt();
        int ans = getSum(b,n1,n2);

        System.out.println(ans);

    }
      public static int getSum(int b, int n1, int n2){
        int rv = 0;
        int carry = 0;
        int count = 0;
        int mul = 1;
        int p=1;

        while(n1 >0 || n2 >0 || carry >0) {

            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;
            int d = d1 + d2 + carry;
            carry = d / b;
            d = d % b;
            rv = rv + d * p;
            p = p * 10;

        }
          return rv;
      }


}
