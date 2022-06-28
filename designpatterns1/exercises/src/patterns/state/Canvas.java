package patterns.state;

public class Canvas {

    Tool currentTool;

    public Canvas(){
        currentTool = new ToolSelection();
    }

    public void mouseDown(){
        currentTool.mouseDown();
    };

    public void mouseUp(){
        currentTool.mouseUp();
    };

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}
