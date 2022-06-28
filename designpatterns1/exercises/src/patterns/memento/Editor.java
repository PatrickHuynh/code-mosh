package patterns.memento;

public class Editor {
    private String content;

    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditorState createState(){
        EditorState state = new EditorState(content);
        return state;
    }

    public void restore(EditorState state){
        this.content = state.getContent();
    }

}
