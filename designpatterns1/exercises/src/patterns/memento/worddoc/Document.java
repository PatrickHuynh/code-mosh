package patterns.memento.worddoc;

import javax.naming.InterruptedNamingException;

public class Document {
    private String content;
    private String fontName;
    private int fontSize;

    public Document(){
        content = "";
        fontName = "Times New Roman";
        fontSize = 12;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFontName(String fontName){
        this.fontName = fontName;
    }

    public void setFontSize(Integer fontSize){
        this.fontSize = fontSize;
    }

    public DocumentState createState(){
        var state = new DocumentState(content, fontName, fontSize);
        return state;
    }

    public void restore(DocumentState  state){
        var data  = state.getState();
        content = (String)data.get("content");
        fontName = (String)data.get("fontName");
        fontSize = (Integer) data.get("fontSize");
    }

}
