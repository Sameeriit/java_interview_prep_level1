package Tree.BinarySearchTree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LargestBSTSubTree {

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class pair{
        int state;
        Node node;
        pair(Node node,int state){
            this.node = node;
            this.state = state;
        }

    }

    public static Node construct(Integer[]arr){
        Node root = new Node(arr[0],null,null);
        pair rtp = new pair(root,1);

        Stack<pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while(st.size() > 0){

            pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node lrn = new Node(arr[idx],null,null);
                    top.node.left = lrn;
                    pair lp = new pair(top.node.left,1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;

            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    Node rrn = new Node(arr[idx],null,null);
                    top.node.right = rrn;
                    pair rp = new pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;

            }else{
                st.pop();
            }
        }
        return root;
    }


    public static void display(IsBst.Node node){
        if(node == null){
            return;
        }
        String str = " ";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" +node.data +"->";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);

    }

    public static class BSTPair{
        boolean isBst;
        int min;
        int max;
        int size; // This Size is  largest bst ki size
        Node root; //This Root is  largest bst ki root
    }
    public static BSTPair isBST(Node node){
        if(node == null){
            BSTPair bp = new BSTPair();
            bp.isBst = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = null;
            bp.size = 0;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBst = lp.isBst && rp.isBst && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data,Math.min(lp.min,rp.min));
        mp.max = Math.max(node.data,Math.max(lp.max,rp.max));

        if(mp.isBst){
            mp.root = node;
            mp.size = lp.size + rp.size + 1;
        }else if(lp.size > rp.size){
            mp.root = lp.root;
            mp.size = lp.size;
        }else{
            mp.root = rp.root;
            mp.size = rp.size;
        }

        return mp;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            if(values[i].equals("n") == false){
                arr[i] = Integer.parseInt(values[i]);
            }else{
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        BSTPair bp = isBST(root);
        System.out.println(bp.root.data + "@" +bp.size);
    }
}
