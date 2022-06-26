import java.util.Arrays;

public class CustomStack {
    private int[] stack;
    private int size;

    public CustomStack(){
        stack = new int[10];
        size = 0;
    }
    public void push(int num){
        if (size == stack.length)
            throw new StackOverflowError();
        stack[size] = num;
        size++;
    }
    public int pop(){
        if (size == 0)
            throw new IllegalStateException();
        int popNum = stack[size-1];
        stack[size] = 0;
        size--;
        return popNum;
    }
    public int peek(){
        if (size == 0)
            throw new IllegalStateException();
        return stack[size-1];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0, size);
        return Arrays.toString(content);
    }
}
