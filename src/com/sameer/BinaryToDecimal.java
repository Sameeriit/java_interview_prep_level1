package com.sameer;
/***
 * lets convert Binary to decimal or Decimal to Binary
 *AUTHOR : Sameeriit
 * date 31-08-2021
 */

import java.util.Scanner;

public class BinaryToDecimal {

    public static void main(String[] args) {

        System.out.print("enter 1 for Binary To Decimal or enter 0 for Decimal to Binary : ");
        Scanner sc = new Scanner(System.in);
        int bool = sc.nextInt();
        if (bool == 1) {

        // THIS CODE IS FOR BINARY TO DECIMAL CONVERSION...!
            int rem1, count = 0, decimal = 0;
            System.out.print("PUT YOUR BINARY NUM HERE : ");
            Scanner sc1 = new Scanner(System.in);
            int num = sc1.nextInt();

            while (num != 0) {
                rem1 = num % 10;
                int value = (int) (Math.pow(2, count));
                decimal = decimal + rem1 * value;
                num /= 10;
                count++;
            }
            System.out.println("HERE IS YOUR DECIMAL :" + decimal);

            // THIS CODE IS FOR DECIMAL TO BINARY CONVERSION....!
        } else if (bool == 0) {

            // public static void main(String[] args) {
            int rem ;
            int count = 0;
            long binary = 0;
            long value ;
            System.out.print("ENTER YOUR DECIMAL HERE : ");
            Scanner scc = new Scanner(System.in);
            int num = scc.nextInt();

            while (num != 0) {
                rem = num % 2;
                value = (long) (Math.pow(10, count));
                binary = binary + rem * value;
                count++;
                num /= 2;

            }
            System.out.println("HERE IS YOUR BINARY : " + binary);
        }
    }
}


