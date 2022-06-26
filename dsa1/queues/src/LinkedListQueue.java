import java.util.LinkedList;

public class LinkedListQueue {

    Node first;
    Node last;
    int count;

    private class Node {
        public int value;
        public Node next;
        public Node(int num){
            value = num;
            next = null;
        }
    }

    public LinkedListQueue(){
        first = null;
        last = null;
        count = 0;
    }

    public void enqueue(int num) {
        Node newNode = new Node(num);
        if (count == 0){
            first = last = newNode;
            first.next = last;
        } else {
            last.next = newNode;
            last = newNode;
        }
        count++;
    }

    public int dequeue(){
        if (count==0)
            throw new IllegalStateException();
        else if (count==1) {
            int num = first.value;
            first = null;
            last = null;
            count--;
            return num;
        } else {
            Node newFirst = first.next;
            int num = first.value;
            first.next = null;
            first = newFirst;
            return num;
        }
    }
}
