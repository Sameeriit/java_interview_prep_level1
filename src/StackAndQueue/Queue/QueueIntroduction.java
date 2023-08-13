package StackAndQueue.Queue;
import java.util.*;

public class QueueIntroduction {
    public static void main(String[] args)throws Exception {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);

        System.out.println(que.peek());
        System.out.println(que);

        System.out.println(que.remove());
        System.out.println(que);
    }
}
