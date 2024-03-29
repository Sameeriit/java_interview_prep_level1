package StackAndQueue.Queue;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

/**
 *      1. You are required to complete the code of our CustomQueue class. The class should mimic the behaviour of a Queue and implement FIFO semantic.
 *      2. Here is the list of functions that you are supposed to complete
 *      2.1. add -> Should accept new data if there is space available in the underlying
 *      array or print "Queue overflow" otherwise.
 *      2.2. remove -> Should remove and return value according to FIFO, if available or
 *      print "Queue underflow" otherwise and return -1.
 *      2.3. peek -> Should return value according to FIFO, if available or print "Queue
 *      underflow" otherwise and return -1.
 *      2.4. size -> Should return the number of elements available in the queue.
 *      2.5. display -> Should print the elements of queue in FIFO manner (space
 *      separated) ending with a line-break.
 *      3. Input and Output is managed for you.
 *
 *      solved:
 *      Author: Sameer Ahmad
 *      date:12/04/2023
 */

public class BuildNormalQueue  {

    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            // write ur code here
            return size;
        }

        void display() {
            // write ur code here
            if(size == 0){
                System.out.println("queue underflow");
            }else{
                for(int i = 0; i < size; i++){
                    int idx = (front + i) % data.length;
                    System.out.print(data[idx] + " ");
                }
                System.out.println();
            }
        }

        void add(int val) {
            // write ur code here
            if(size == data.length){
                System.out.println("queue overflow");
            }else{
                int rare = (front + size) % data.length;
                data[rare] = val;
                size++;
            }
        }

        int remove() {
            // write ur code here
            if(size == 0){
                System.out.println("queue underflow");
                return -1;
            }else{
                int val =  data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek() {
            // write ur code here
            if(size == 0){
                System.out.println("queue underflow");
                return -1;
            }else{
                return data[front];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(qu.size());
            } else if(str.startsWith("display")){
                qu.display();
            }
            str = br.readLine();
        }
    }
}