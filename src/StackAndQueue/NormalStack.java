package StackAndQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. You are required to complete the code of our CustomStack class. The class should mimic the behaviour of java.util.Stack class and implement LIFO semantic.
 * 2. Here is the list of functions that you are supposed to complete
 *    2.1. push -> Should accept new data if there is space available in the underlying
 *    array or print "Stack overflow" otherwise.
 *    2.2. pop -> Should remove and return last data if available or print "Stack
 *    underflow" otherwise and return -1.
 *    2.3. top -> Should return last data if available or print "Stack underflow"
 *    otherwise and return -1.
 *    2.4. size -> Should return the number of elements available in the stack.
 *    2.5. display -> Should print the elements of stack in LIFO manner (space
 *    separated) ending with a line-break.
 * 3. Input and Output is managed for you.
 *
 * solved:
 * Author : Sameer Ahmad
 * date : 9/4/2023
 */

public class NormalStack {


    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            // write ur code here
            return tos + 1;
        }

        void display() {
            // write ur code here
            if(tos == -1){
                System.out.println("Stack is Empty");
            }else{
                for(int i = tos; i >= 0; i-- ){
                    System.out.print(data[i] + " ");
                }
                System.out.println();
            }


        }

        void push(int val) {
            // write ur code here
            if(tos == data.length - 1){
                System.out.println("Stack Overflow");
            }else{
                tos++;
                data[tos] = val;
//                System.out.println();
            }

        }

        int pop() {
            // write ur code here
            if(tos == -1){
                System.out.println("Stack Under flow");
                return -1;
            }else{
                int val = data[tos];
                tos--;
                return val;
            }

        }

        int top() {
            // write ur code here
            if(tos == -1){
                System.out.println("Stack Under flow");
                return -1;
            }else{
                int val = data[tos];
                return val;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }


    }

}
