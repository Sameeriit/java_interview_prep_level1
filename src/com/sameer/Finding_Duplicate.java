package com.sameer;


import java.util.Scanner;

public class Finding_Duplicate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String ans = searchString(word);
    }


    public static String searchString(String str) {
        String ss =null;
        if (str.length() == 0) {
            return "noWord";
        }
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == str.charAt(index + 1)) {

            }
           System.out.println(str.charAt(index));
        }
        return ss;


    }
}