public class PriorityArrayQueue {
    int[] items;
    int count;

    public PriorityArrayQueue(int capacity){
        items = new int[capacity];
        count = 0;
    }

    public void enqueue(int num){
        if (count == items.length)
            throw new IllegalStateException();
        int insertionIndex = shiftItemsAndGetInsertionIndex(num);
        items[insertionIndex] = num;
        count++;
    }

    private int shiftItemsAndGetInsertionIndex(int num) {
        int insertionIndex = count;
        for (int i = count - 1; i >= 0; i--){
            if (items[i] > num){
                items[i+1] = items[i];
                insertionIndex = i;
            } else {
                break;
            }
        }
        return insertionIndex;
    }

    public int dequeue(){
        if (count == 0)
            throw new IllegalStateException();
        int output = items[count-1];
        items[count-1] = 0;
        count--;
        return output;
    }
    public int peek(){
        return items[count-1];
    }
    public boolean isEmpty(){
        return count == 0;
    }
}
