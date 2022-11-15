package Tree.BinaryTree;
import java.util.*;

/**
 * introduction of binary tree
 * here we are going to construct binary tree and display in pre order
 * Author: Sameer Ahmad
 * date : 25/07/2022
 */



public class IntroductionToBinaryTree {
    private static class Node{
        int  data;
        Node left;
        Node right;

        Node(int data,Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class pair{
        Node node;  // this node have three things -> data,left node,right node
        int state;
        pair(Node node ,int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";

        str += (node.left == null) ?"." : node.left.data +"";
        str += "<-"+ node.data +"->";
        str += (node.right == null) ?"." : node.right.data +"";

        System.out.println(str);


        display(node.left);
        display(node.right);
    }

    // construction of binary tree
    public  static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root  = new Node(arr[0],null,null);  // make root node
        pair root_pair = new pair(root,1);            // root pair

        Stack<pair> st = new Stack<>();
        st.push(root_pair);

        int idx = 0;
        while(st.size() > 0){
            pair top = st.peek();    // make top as pair so that we can see state and node properties

            if(top.state == 1){   // go to left child and work
                idx++;

                if(arr[idx] != null){
                    Node ln = new Node(arr[idx],null,null);
                    top.node.left = ln;
                    pair lnp = new pair(ln,1);
                    st.push(lnp);
                }else{
                    top.node.left = null;
                }
                top.state++;

            }else if(top.state == 2){   // go to right child and work
                idx++;

                if(arr[idx] != null){
                    Node rn = new Node(arr[idx],null,null);
                    top.node.right = rn;
                    pair rnp = new pair(rn,1);
                    st.push(rnp);
                }else{
                    top.node.right = null;
                }
                top.state++;

            }else{
                st.pop();
            }

        }

        display(root);




    }
}
