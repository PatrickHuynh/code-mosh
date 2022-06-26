import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayPat numbers = new ArrayPat(3);
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.removeAt(2);
        System.out.println(numbers.indexOf(3));
        System.out.println(numbers.indexOf(100));
        numbers.print();
    }
}

