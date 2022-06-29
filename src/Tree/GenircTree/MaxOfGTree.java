package Tree.GenircTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MaxOfGTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node root){ // here i write tree display method
        String str = root.data+"->";
        for(Node child : root.children){
            str += child.data+",";
        }
        System.out.println(str+".");
        for(Node child: root.children){
            display(child);
        }
    }

    public static Node construct(int []arr){  // construct tree method
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]== -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];
                if(st.size() > 0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);

            }
        }
        return root;

    }
    public static int size( Node root){
        int s = 0;
        for(Node child : root.children){
            int cs = size(child);
            s +=cs;
        }
        s = s + 1;
        return s;
    }

    public static int max(Node root){// finding maximum of all the node of tree
        //write your code here
        int max = Integer.MIN_VALUE;   // identity of maximum
        for(Node child: root.children){
            int cm = max(child);
            max = Math.max(cm,max);   // checking max here
        }
        max = Math.max(root.data,max); // if there is no child then we check max for root.data
        return max;


    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[]values = br.readLine().split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(values[i]);
        }
        Node root = construct(arr);
        int m = max(root);
        System.out.println(m);

//        int sz = size(root);
//        System.out.println(sz);

//        display(root);


    }
}
