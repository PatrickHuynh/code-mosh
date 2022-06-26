import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverseQueue(queue);
        System.out.println(queue);

        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q);
        q.dequeue();
        q.enqueue(60);
        System.out.println(q);

        StackQueue k = new StackQueue();
        k.enqueue(10);
        k.enqueue(20);
        k.enqueue(30);
        k.enqueue(40);
        k.enqueue(50);
        k.dequeue();
        k.enqueue(60);
        k.dequeue();
        k.dequeue();
        k.dequeue();
        k.dequeue();
        k.dequeue();

        //priority queues
        PriorityArrayQueue j = new PriorityArrayQueue(10);
        j.enqueue(10);
        j.enqueue(20);
        j.enqueue(30);
        j.enqueue(40);
        j.enqueue(50);
        j.dequeue();
        j.enqueue(1);
        j.enqueue(10);
        while (!j.isEmpty())
            System.out.println(j.dequeue());

        // linkedlistqueue
        LinkedListQueue p = new LinkedListQueue();
        p.enqueue(10);
        p.enqueue(20);
        p.enqueue(30);
        p.enqueue(40);
        p.enqueue(50);
        System.out.println(p.dequeue());
        p.enqueue(1);
        p.enqueue(10);
        System.out.println(p.dequeue());
    }

    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
}