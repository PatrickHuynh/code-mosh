import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public StackQueue(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    public void enqueue(int num){
        stackIn.push(num);
    }

    private void refillOutputStack(){
        if (stackOut.isEmpty())
            while (!stackIn.isEmpty())
                stackOut.push(stackIn.pop());
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();
        refillOutputStack();
        return stackOut.pop();
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();
        refillOutputStack();
        return stackOut.peek();
    }
    public boolean isEmpty(){
        return (stackIn.isEmpty() && stackOut.isEmpty());
    }
}

