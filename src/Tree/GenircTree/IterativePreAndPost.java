package Tree.GenircTree;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * problem on Generic Tree (iterative pre order and post order of  g tree)
 * solution:
 * Author: Sameer Ahmad
 * date: 19/07/2022
 */

public class IterativePreAndPost {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    // i write code  from here
    static class pair{ // pair class
        Node node;
        int state;
        pair(Node node, int state){ //constructor
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreAndPostOrder(Node node) {
        // write your code here

        Stack<pair> st = new Stack<>();
        st.push(new pair(node, -1));

        String pre = "";
        String post = "";

        while(st.size() > 0){
            pair top = st.peek();
            if(top.state == -1){       //pre area
                pre += top.node.data + " ";
                top.state++;

            }else if( top.state == top.node.children.size()){ // post area
                post += top.node.data + " ";
                st.pop();

            }else{
                pair cp = new pair(top.node.children.get(top.state), -1); // in between
                st.push(cp);
                top.state++;

            }
        }

        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        IterativePreAndPostOrder(root);
    }


}
