package Tree.GenircTree;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * problem on Generic Tree (Node with maximum sub tree  of  g tree)
 * solution:
 * Author: Sameer Ahmad
 * date: 19/07/2022
 */

public class NodeWithMaxSubTree {
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
   // i write code from  here
    // this two variable in heap area
    static int msn = 0;
    static int ms = Integer.MIN_VALUE;
    static int retSumAndCalculateMSST(Node node){
        int sum = 0;
        for(Node child: node.children){
            int child_sum = retSumAndCalculateMSST(child);
            sum += child_sum; // adding here child data
        }
        sum += node.data;  // adding here self data

        if(sum > ms){      // updating maximum sum node and maximum sum it will be persistent
            msn = node.data;
            ms = sum;
        }
        return sum;

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
        retSumAndCalculateMSST( root);
        System.out.println(msn +"@"+ ms);
    }
}
