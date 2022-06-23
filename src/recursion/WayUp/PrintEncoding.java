package recursion.WayUp;
import java.util.*;

public class PrintEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        print_Encodings(str,"");

    }
    public static void print_Encodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;

        } else if (str.length() == 1) {
            char ch = str.charAt(0);

            if (ch == 0) {
                return;
            } else {
                int chv = ch - '0';   // character value in integer
                char code = (char) ('a' + chv - 1);   // code encoded in character
                System.out.println(asf + code);
            }

        } else { // for choosing one character

            char ch = str.charAt(0);
            String ros = str.substring(1);

            if (ch == 0) {
                return;
            } else {
                int ch1v = ch - '0';  // character one value
                char code = (char) ('a' + ch1v - 1);
                print_Encodings(ros, asf + code);
            }
            // for choosing two character

            String ch12 = str.substring(0, 2); //character one and two
            String ros12 = str.substring(2);  // from two to all

            int ch12v = Integer.parseInt(ch12); // this is because ch12(character one two value) come here as a string
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                print_Encodings(ros12, asf + code);

            }
        }
    }


}
