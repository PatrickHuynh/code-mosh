package patterns.memento;

import java.util.Stack;

public class History {
    private Stack<EditorState> states;

    public History(){
        states = new Stack<>();
    }

    public void push(EditorState state){
        states.push(state);
    }

    public EditorState pop(){
        return states.pop();
    }
}
