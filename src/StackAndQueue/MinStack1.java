package StackAndQueue;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * problem MinStack 1
 * 1. You are required to complete the code of our MinStack class.
 * 2. As data members you've two stacks available in the class - one for data values and another for minimum values. (This is cryptic - take hint from video)
 * 2. Here is the list of functions that you are supposed to complete
 * 2.1. push -> Should accept new data in LIFO manner
 * 2.2. pop -> Should remove and return data in LIFO manner. If not available, print "Stack underflow" and return -1.
 * 2.3. top -> Should return data in LIFO manner. If not available, print "Stack underflow" and return -1.
 * 2.4. size -> Should return the number of elements available in the stack
 * 2.5. min -> Should return the smallest element available in the stack. If not available, print "Stack underflow" and return -1.
 * 3. Input and Output is managed for you.
 *
 * Note -> The judge may not be able to check if all your functions are O(1) in time, but that is what the expectation is.
 *
 * Author : Sameer Ahmad
 * Date : 23/04/2023
 *
 */

public class MinStack1 {

    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }


        int size() {
            // write your code here
            return allData.size();
        }

        void push(int val) {
            // write your code here
            allData.push(val);
            if(minData.size() == 0 || val <= minData.peek()){
                minData.push(val);
            }
        }

        int pop() {
            // write your code here
            if(size() == 0){
                System.out.println("stack underflow");
                return -1 ;
            }else{
                int val = allData.pop();
                if(val == minData.peek()){
                    minData.pop();
                }
                return val;
            }
        }

        int top() {
            // write your code here
            if(size() == 0){
                System.out.println("stack underflow");
                return -1 ;
            }else{
                return allData.peek();
            }


        }

        int min() {
            // write your code here
            if(size() == 0){
                System.out.println("stack underflow");
                return -1 ;
            }else{
                return minData.peek();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
