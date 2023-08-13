package StackAndQueue;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**  problem
 * 1. You are required to complete the code of our TwoStack class. The class should implement LIFO behaviours for two stacks in the same array.
 * 2. Here is the list of functions that you are supposed to complete
 *     2.1. push1, push2 -> Should accept new data for appropriate stack if there is
 *     space available in the underlying array or print "Stack overflow" otherwise.
 *     2.2. pop1, po2 -> Should remove and return data from appropriate stack if
 *     available or print "Stack underflow" otherwise and return -1.
 *     2.3. top1, top2 -> Should return data from appropriate stack if available or print
 *     "Stack underflow" otherwise and return -1.
 *     2.4. size1, size2 -> Should return the number of elements available in appropriate
 *      stack.
 * 3. Input and Output is managed for you.
 * Author : Sameer Ahmad
 * Date : 16/05/2023
 */

public class TwoStackInArray {

    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            // write your code here
            data = new int[cap];
            tos1 = 0;
            tos2 = data.length;
        }

        int size1() {
            // write your code here
            return tos1 + 1;
        }

        int size2() {
            // write your code here
            return tos2 -1;
        }

        void push1(int val) {
            // write your code here
            if(tos1 + 1 == tos2 ){
                System.out.println("Stack Overflow");
            }else{
                tos1 +=1;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            // write your code here
            if(tos2 - 1 == tos1 ){
                System.out.println("Stack Overflow");
            }else{
                tos2 -=1;
                data[tos2] = val;
            }
        }

        int pop1() {
            // write your code here
            if(data[tos1] == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos1--];
                return val;

            }
        }

        int pop2() {
            // write your code here
            if(data[tos2] == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos2++];
                return val;
            }
        }

        int top1() {
            // write your code here
            if(data[tos1] == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos1];
                return val;
            }
        }

        int top2() {
            // write your code here
            if(data[tos2] == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int val = data[tos2];
                return val;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TwoStack st = new TwoStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            } else if (str.startsWith("pop1")) {
                int val = st.pop1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top1")) {
                int val = st.top1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size1")) {
                System.out.println(st.size1());
            } else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            } else if (str.startsWith("pop2")) {
                int val = st.pop2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top2")) {
                int val = st.top2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size2")) {
                System.out.println(st.size2());
            }
            str = br.readLine();
        }
    }
}
