package com.sameer;
import java.util.*;
import java.util.Scanner.*;

public class anyBasetoanyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sourceBase = sc.nextInt();
        int destBase = sc.nextInt();
        int n = sc. nextInt();

        int d = getAnswer(n,sourceBase,destBase);
        System.out.println(d);

        }

        public static int getAnswer(int n,int b1, int b2){
        int decimal = anyBasetoDecimal(n,b1);
        int destination = decimaltoanyBase(decimal,b2);
        return destination;

    }

    public static int anyBasetoDecimal(int n ,int b1){

        int rv = 0 ;

        int p = 1;

        while(n > 0 ){
            int dgt = n % 10;

            rv += dgt * p;
            p = p * b1;


            n /=10;
        }
        return rv;



    }


    public static int decimaltoanyBase(int n, int b2){

        int rv = 0 ;

        int p = 1;

        while(n > 0 ){
            int dgt = n % b2; // digit finding ( base we want go that b2)

            rv += dgt * p;
            p = p * 10;     //power  multiply from the base where you are currently


            n /=b2;          // small the digit from the same base where you want to go
        }
        return rv;

    }



}
