package linkedList;

public class IntroductionToLinkedList {
    public static class Node {
        int data ;
        Node next;
    }
    public static class Linkedlist{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public int size(){
            return size();
        }
        public  void display() {
            Node temp = head;
            while(temp.next != null){
                System.out.println(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();


        }
    }
}
