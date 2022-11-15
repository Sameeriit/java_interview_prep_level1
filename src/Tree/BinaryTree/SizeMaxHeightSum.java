package Tree.BinaryTree;

import Tree.BinaryTree.SizeMaxHeightSum.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class SizeMaxHeightSum {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class pair {
        Node node;
        int state;

        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // construction of tree
    public static Node construct(Integer[] arr) {
        // write your code here
        Node root = new Node(arr[0], null, null);
        pair root_pair = new pair(root, 1);

        Stack<pair> st = new Stack<>();
        st.push(root_pair);
        int idx = 0;
        while (st.size() > 0) {
            pair top = st.peek();

            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    Node ln = new Node(arr[idx], null, null); // left node
                    top.node.left = ln;
                    pair lrp = new pair(ln, 1);
                    st.push(lrp);
                } else {
                    top.node.left = null;
                }

                top.state++;

            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;
                    pair rnp = new pair(rn, 1);
                    st.push(rnp);

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


    public static void display(Node node){
        // write your code here
        if(node == null){
            return;
        }
        String str = "";

        str += (node.left == null)? ".": node.left.data +"";
        str += "<-" + node.data +"->";
        str += (node.right == null)? ".":node.right.data +"";

        System.out.println(str);


        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        // write your code here
        if (node == null){
            return 0;
        }
        int ln = size(node.left);
        int rn = size(node.right);
        int ts = ln + rn + 1;

        return ts;
    }

    public static int sum(Node node) {
        // write your code here
        if(node == null){
            return 0;
        }
        int lnSUM = sum(node.left);
        int rnSUM = sum(node.right);
        int totSUM = lnSUM + rnSUM + node.data;

        return totSUM;
    }

    public static int max(Node node) {
        // write your code here
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lMax = max(node.left);
        int rMax = max(node.right);
        int tMax = Math.max(node.data,Math.max(lMax,rMax));

        return tMax;

    }

    public static int height(Node node) {
        // write your code here
        if(node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh,rh) + 1;

        return th;

    }


    public static void main(String [] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String [] value = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            if(value[i].equals("n") == false) {
                arr[i] = Integer.parseInt(value[i]);
            }else{
                arr[i] = null;
            }
        }

        Node root = construct(arr);
//        display(root);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);


    }

}


