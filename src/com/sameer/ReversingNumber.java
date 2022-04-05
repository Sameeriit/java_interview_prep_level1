package com.sameer;

import java.util.Scanner;

public class ReversingNumber {
        public static void main(String[] args){
            int rem,count=0,reverse = 0;
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            while(num !=0){
                rem = num % 10;
                reverse = reverse * 10 + rem;
                num /=10;
                count++;
            }
            System.out.println(reverse);
            System.out.println(count);

        }
    }

