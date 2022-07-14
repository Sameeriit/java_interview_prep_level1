package Tree.GenircTree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * problem on GENRIC tree( Node To root path of  genric tree)
 * solution
 * Author: Sameer Ahmad
 * date: 09-07-2022
 */

public class NodeToRootPath {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here

        // CHECK YOUR SELF
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        // CHECK ON YOUR EVERY CHILD AND FIND PATH TILL THE CHILD
        for(int i = 0; i < node.children.size(); i++){
            Node child = node.children.get(i);
            ArrayList<Integer> path_till_child = nodeToRootPath(child,data);
            if(path_till_child.size() > 0){   // THIS MEANS THERE IS SOME PATH
                path_till_child.add(node.data);
                return path_till_child;
            }

        }
        // IF YOU ARE NOT GETTING THEN RETURN EMPTY ARRAYLIST
        return new ArrayList<>();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);
        // display(root);
    }

}