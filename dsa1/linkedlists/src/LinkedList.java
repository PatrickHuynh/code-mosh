import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int item) {
            this.value = item;
        }
    }
    private Node first;
    private Node last;
    private int size;

    // addFirst
    public void addFirst(int item){
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    // addLast
    public void addLast(int item){
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // deleteFirst
    public void removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        } else if (first == last) {
            first = null;
            last = null;
        } else {
            var newFirstNode = first.next;
            first.next = null;
            first = newFirstNode;
        }
        size--;
    }

    // deleteLast
    public void removeLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (first == last) {
            first = null;
            last = null;
        } else if (first.next == last) {
            first.next = null;
            last = first;
        } else {
            var secondLastNode = first.next;
            while (secondLastNode.next.next != null){
                secondLastNode = secondLastNode.next;
            }
            secondLastNode.next = null;
            last = secondLastNode;
        }
        size--;
    }

    // contains
    public boolean contains(int item){
        return (indexOf(item) != -1);
    }

    // indexOf
    public int indexOf(int item){
        var currentNode = first;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value == item) return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    private boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return this.size;
    }

    public int[] toArray(){
        int[] outputArray = new int[this.size];
        var current = first;
        int i = 0;
        while (current != null){
            outputArray[i] = current.value;
            current = current.next;
            i++;
        }
        return outputArray;
    }

    public void reverse() {
        if (isEmpty()){
            return;
        } else if (first == last) {
            return;
        } else {
            Node nodeA = null;
            Node nodeB = first;
            Node nodeC = first.next;
            do {
                nodeB.next = nodeA;
                nodeA = nodeB;
                nodeB = nodeC;
                nodeC = nodeC.next;
            } while (nodeB != last);
            last = first;
            last.next = null;
            first = nodeB;
            first.next = nodeA;
        }
    }

    public int getKthValueFromEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        Node targetNode = first;
        Node tailNode = first;
        for (int i = 0; i <= k - 1; i++){
            tailNode = tailNode.next;
            if (tailNode == null)
                throw new IllegalArgumentException();
        }
        while (tailNode != last) {
            targetNode = targetNode.next;
            tailNode = tailNode.next;
        }
        return targetNode.value;
    }

    public void printMiddle(){
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        var nodeA = first;
        var nodeB = first;
        int count = 1;
        while (nodeB != last){
            if (count % 2 == 0){
                nodeA = nodeA.next;
            }
            nodeB = nodeB.next;
            count++;
        }
        if (count % 2 == 0){
            System.out.println(nodeA.value);
            System.out.println(nodeA.next.value);
        } else {
            System.out.println(nodeA.value);
        }
    }

    public boolean hasLoop(){
        var nodeSlow = first;
        var nodeFast = first;
        while (nodeSlow != last) {
            for (int i = 0; i < 2; i++){
                nodeFast = nodeFast.next;
                if (nodeFast == nodeSlow){
                    return true;
                }
                if (nodeFast == null){
                    return false;
                }
            }
            nodeSlow = nodeSlow.next;
        }
        return false;
    }

    public void makeLoop(){
        last.next = first;
    }
    public void removeLoop (){
        last.next = null;
    }
}

