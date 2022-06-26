import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // string reverser example
        StringReverser revStr = new StringReverser();
        System.out.println(revStr.reverse("ABCD"));
        //System.out.println(revStr.reverse(null));

        // balanced expression example
        BalancedExpression bExp = new BalancedExpression();
        System.out.println(bExp.checkBalanced("(([1]+<2>))[a]"));
        System.out.println(bExp.checkBalanced("(([1]+<2>))[a ]"));
        System.out.println(bExp.checkBalanced("(([1]+<2>))<a]"));
        System.out.println(bExp.checkBalanced(""));
        System.out.println(bExp.checkBalanced("}"));
        //System.out.println(bExp.checkBalanced(null));

        // custom stack code
        CustomStack numStack = new CustomStack();
        numStack.push(1);
        numStack.push(2);
        System.out.println(numStack.pop());
        System.out.println(numStack.peek());
        numStack.push(7);
        numStack.push(8);
        System.out.println(numStack.isEmpty());
        System.out.println(numStack);
    }
}
