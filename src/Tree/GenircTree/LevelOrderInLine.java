package Tree.GenircTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
/**
 * problem on genric tree print node level order in line
 * solution
 * Author: Sameer Ahmad
 * date: 4/07/2022
 */

public class LevelOrderInLine {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();


        Node(){         // this constructor is because we passed a parametrise constructor
                        // because java remove default constructor
        }
        Node (int data){
            this.data = data;
        }
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

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);

        for(Node child: node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    public static void levelOrderLine_wise1(Node root){
        // write your code here
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        Queue<Node> chq  = new ArrayDeque<>();
        while(mq.size() > 0){
            root = mq.remove();
            System.out.print(root.data +" ");

            for(Node child: root.children){
                chq.add(child);
            }

            if(mq.size() ==0){
                mq = chq;
                chq = new ArrayDeque<>();
                System.out.println();
            }
        }

    }

    public static void levelOrderLine_wise2(Node root){   // with the help of null concept or delimeter concept
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        mq.add(new Node(-1));
        while(mq.size() > 0){
            root = mq.remove();
            if (root.data != -1) {
                System.out.print(root.data +" ");
                for(Node child: root.children) {
                    mq.add(child);
                }

            }else{
                if(mq.size() > 0) {
                    mq.add(new Node(-1));
                    System.out.println();
                }

            }
        }
    }


    public static void levelOrderLine_wise3(Node root){   // size counter concept on the every level
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        while(mq.size() > 0) {
            int qsize = mq.size();
            for (int i = 0; i < qsize; i++) {
                  root = mq. remove();
                  System.out.print(root.data +" ");
                  for(Node child: root.children){
                      mq.add(child);
                  }
            }
            System.out.println();
        }



    }

    public static class Pair{
        Node node;
        int level;

        Pair(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }


    public static void levelOrderLine_wise4(Node root){ // with help of pair class we use here pair queue
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(root, 1));
        int level = 1;
        while(mq.size() > 0){
            Pair p = mq.remove();
            if(p.level > level){
                level = p.level;
                System.out.println();

            }
            System.out.print(p.node.data +" ");
            for(Node child: p.node.children){
               Pair cp = new Pair(child,p.level + 1) ;
               mq.add(cp);
            }
        }
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
        levelOrderLine_wise4(root);
    }
}
