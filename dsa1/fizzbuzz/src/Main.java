import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // parse input
        System.out.print("Input Number: ");
        Scanner inputLine = new Scanner(System.in);
        long inputNumber = inputLine.nextLong();

        // check divisible by 3, or 5
        boolean isDivisibleBy3 = (inputNumber % 3 == 0);
        boolean isDivisibleBy5 = (inputNumber % 5 == 0);

        // apply fizzbuzz
        if (isDivisibleBy3 && isDivisibleBy5) {
            System.out.println("FizzBuzz");
        } else if (isDivisibleBy3) {
            System.out.println("Buzz");
        } else if (isDivisibleBy5) {
            System.out.println("Fizz");
        } else {
            System.out.println(inputNumber);
        }
    }
}