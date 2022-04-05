package com.sameer;
import java.util.Scanner;
public class findPower {
    public static void main(String[] args) {
        int pow = 1;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(b==0){
            System.out.println(1);
        }else
        while(b!=0) {
            pow *=a;
            b--;
        }
        System.out.println(pow);
        int res = pow %10;
        System.out.println(res);
    }
}
