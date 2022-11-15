package Tree.BinaryTree;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * problem: print K_NODE_FAR of binary tree
 * solution: here we are going to print k distance away from the given node  of binary tree
 * Author: Sameer Ahmad
 * date : 6/08/2022
 */

public class PrintKNodeFar {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // we are using print k level down and node to root path with little bit modification and complete the
    // print k distance away method

    static ArrayList<Node> path ;
    public static boolean nodeToRootPath(Node node,int data){
        if(node == null ){
            return false;
        }
        if(node.data == data){
            path.add(node);
            return true;
        }
        boolean flc = nodeToRootPath(node.left,data);
        if(flc){
            path.add(node);
            return true;
        }
        boolean frc = nodeToRootPath(node.right,data);
            if(frc){
                path.add(node);
                return true;
            }
        return false;
    }


    public static void printKLevelDown(Node node, int k,Node blocker){
        if(node == null || k < 0 || node ==  blocker){
            return;
        }if(k == 0){
            System.out.println(node.data);
        }
        printKLevelDown(node.left , k-1,blocker);
        printKLevelDown(node.right ,k-1,blocker);
    }

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        path = new ArrayList<>();
        nodeToRootPath(node,data);
        for(int i = 0 ; i < path.size(); i++){
            printKLevelDown(path.get(i), k - i, i==0?null:path.get(i-1));
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }
}
