package patterns.memento.worddoc;

import java.util.Stack;

public class DocumentHistory {
    Stack<DocumentState> stack = new Stack<>();

    public void push(DocumentState state){
        stack.push(state);
    }

    public DocumentState pop(){
        if (stack.size() == 0)
            throw new IllegalStateException("Cannot undo, stack is empty.");
        return stack.pop();
    }
}
