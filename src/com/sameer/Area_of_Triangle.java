package com.sameer;

/** Basic java programs
 * 2.Area of Triangle
 * author : sameeriit
 */

import java.util.Scanner;
public class Area_of_Triangle {

    public static void main(String[] args) {
    int length ,breath;
    float Area = 0;
    Scanner input = new Scanner(System.in);
    length = input.nextInt();
    breath = input.nextInt();
     Area = (length * breath)/2;

        System.out.println(Area);


    }
}
