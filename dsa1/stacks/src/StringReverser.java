import java.util.Stack;

public class StringReverser {
    public String reverse(String str){
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }
        StringBuffer reversedStr = new StringBuffer(); // String buffer allows a string
        while (!stack.empty()){
            reversedStr.append(stack.pop());
        }
        return reversedStr.toString();
    }
}
