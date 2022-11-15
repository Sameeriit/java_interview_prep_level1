package Tree.BinaryTree;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

/**
 * problem on binary tree transform back to left clone
 * solution:
 * Author: Sameer Ahamd
 * date : 16/08/2022
 */
public class BackTransformFromLeftCloneTree {

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

    public static class pair {
        Node node;
        int state;

        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
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
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    pair lp = new pair(ln, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;
                    pair rp = new pair(rn, 1);
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

    public static Node transBackFromLeftCloned(Node node) {
        if (node == null) {
            return null;
        }
        // here we are going to jump and left the middle node
        // because that middle node is actually left clone
        Node left_of_left_node = transBackFromLeftCloned(node.left.left);
        Node right_node = transBackFromLeftCloned(node.right);
        node.left = left_of_left_node;
        node.right = right_node;

        return node;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] value = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (value[i].equals("n") == false) {
                arr[i] = Integer.parseInt(value[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        root = transBackFromLeftCloned(root);
        display(root);

    }

}

