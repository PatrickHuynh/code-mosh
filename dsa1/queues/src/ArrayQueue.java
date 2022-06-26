import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;
    private int size;

    public ArrayQueue(int capacity){
        items = new int[capacity];
        front = 0;
        rear = 0;
        count = 0;
        size = capacity;
    }
    public void enqueue(int num){
        if (count >= size)
            throw new IllegalStateException(); // full
        items[rear] = num;
        rear = (rear + 1) % size; // circular array
        count++;
    }
    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException(); // empty
        int num;
        num = items[front];
        items[front] = 0;
        front = (front + 1) % size; // circular array
        count--;
        return num;
    }
    public int peek(){
        return items[front];
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return !this.isEmpty();
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
