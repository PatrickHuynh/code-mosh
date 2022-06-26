import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addFirst(5);
        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(30));
        System.out.println(list.indexOf(2));
        System.out.println(list.contains(40));
        System.out.println(list.contains(10));
        list.removeFirst();
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthValueFromEnd(0));
        System.out.println(list.getKthValueFromEnd(1));
        System.out.println(list.getKthValueFromEnd(2));
        System.out.println(list.getKthValueFromEnd(3));
        list.printMiddle();
        list.addLast(60);
        System.out.println(Arrays.toString(list.toArray()));
        list.printMiddle();
        list.makeLoop();
        System.out.println(list.hasLoop());
        list.removeLoop();
        System.out.println(list.hasLoop());
    }
}