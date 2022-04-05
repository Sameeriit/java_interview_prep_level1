package com.sameer;

import java.util.Scanner;

/**Basic java programs
 *  1.Area of circle
 *  author : sameeriit
 */

 public class conditional_loop {
    public static void main(String[] args) {
        double pi =  3.14;
        System.out.print("Put The Radius Here : ");
        Scanner rds = new Scanner(System.in);
        int radius = rds.nextInt();
        double Area = pi*(radius*radius);
        System.out.println("Area of circle : " + Area);
    }
}
