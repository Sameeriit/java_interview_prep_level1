package Tree.GenircTree;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * problem on Generic Tree (diameter  of  g tree)
 * solution:
 * Author: Sameer Ahmad
 * date: 19/07/2022
 */

public class DiameterOfGTree {
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
    // I write code  from here
    static int diameter = 0;
    static int calculateDiaReturnHeight(Node node){
        int dch = -1; // deepest child height
        int sdch = -1; // second deepest child height
        for(Node child : node.children){
            int ch = calculateDiaReturnHeight(child);  // child height
            if(ch > dch){
                sdch = dch;
                dch = ch;
            }else if(ch >sdch){
                sdch = ch;
            }
        }
        int candidate = dch + sdch + 2; // candidate node from which we calculate distance

        if(candidate > diameter){
            diameter = candidate;
        }
        dch += 1;
        return dch;
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
        // write your code here
        calculateDiaReturnHeight(root);
        System.out.println(diameter);

    }
}
