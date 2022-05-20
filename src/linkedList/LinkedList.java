package linkedList;

public class LinkedList {


    private Node head;
    private Node tail;
    private int size ;

    public LinkedList() {
        this.size = 0;

    }

    public  void addFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(tail == null){
            head = tail;
        }

    }


    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public Node (int data,Node next){
            this.data= data;
            this.next = next;
        }


    }

}
