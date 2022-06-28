package patterns.memento.worddoc;

import java.util.HashMap;
import java.util.Map;

public class DocumentState {
    private final String content;
    private final String fontName;
    private final int fontSize;

    public DocumentState(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
    }


    public Map getState() {
        Map<String, Object> state = new HashMap<>();
        state.put("content", content);
        state.put("fontName", fontName);
        state.put("fontSize", fontSize);
        return state;
    }

    @Override
    public String toString() {
        Map<String, Object> state = new HashMap<>();
        state.put("content", content);
        state.put("fontName", fontName);
        state.put("fontSize", fontSize);
        return state.toString();
    }
}
