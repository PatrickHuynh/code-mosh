import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private final List<Character> leftBrackets = Arrays.asList('(','{','[','<');
    private final List<Character> rightBrackets = Arrays.asList(')','}',']','>');

    public boolean checkBalanced(String str){
        if (str == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        char[] charArray = str.toCharArray();
        char prevBracket;
        for (char chr: charArray){
            if (isLeftBracket(chr)){
                stack.push(chr);
            }
            if (isRightBracket(chr)){
                if (stack.isEmpty()) return false;
                prevBracket = stack.pop();
                if (!bracketsMatch(prevBracket, chr)) return false;
            }
        }
        return true;
    }

    private boolean isLeftBracket(Character chr){
        return leftBrackets.contains(chr);
    };
    private boolean isRightBracket(Character chr){
        return rightBrackets.contains(chr);
    };
    private boolean bracketsMatch(Character left, Character right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    };
}
