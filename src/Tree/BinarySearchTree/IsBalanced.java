package Tree.BinarySearchTree;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Stack;

public class IsBalanced {
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
    // one way 1st function using static variable concept travel and change
    static boolean isbalance = true;
    public static int isbalanced(Node node){
        if(node == null){
            return 0;
        }

        int lh = isbalanced(node.left);
        int rh = isbalanced(node.right);

        int gap = Math.abs(lh - rh);
        if(gap > 1){
            isbalance = false;
        }

        int mh = Math.max(lh,rh) + 1;
        return mh;

    }

    // other way 2nd function using pair class
    public static class Balpair {
        int height;
        boolean isbal;
    }
    public static Balpair isbalance(Node node){
        if(node == null){
            Balpair bp = new Balpair();
            bp.height = 0;
            bp.isbal = true;
            return bp;
        }
        Balpair lp = isbalance(node.left);
        Balpair rp = isbalance(node.right);

        Balpair mp = new Balpair();
        mp.height = Math.max(lp.height,rp.height) + 1;
        mp.isbal = Math.abs(lp.height - rp.height) <=1 && rp.isbal && lp.isbal; // -1<=bf<=1
        return mp;

    }
    public static class pair{
        Node node;
        int state;
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

            }else if(top.state ==2){
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

            }else {
                st.pop();
            }

        }
        return root;
    }

    public static void main(String[]  args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[n];
        String[] values = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            if(values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            }else{
                arr[i] = null;
            }
        }
        Node root = construct(arr);

        //call for 1st function.......
//        int ans = isbalanced(root);
//        System.out.println(isbalance);

        // call for 2nd function......
        Balpair bp = isbalance(root);
        System.out.println(bp.isbal);

    }
}
