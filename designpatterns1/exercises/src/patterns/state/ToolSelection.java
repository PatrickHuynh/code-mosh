package patterns.state;

public class ToolSelection implements Tool{
    @Override
    public void mouseDown(){
        System.out.println("Selection icon");
    };

    @Override
    public void mouseUp(){
        System.out.println("Draw dashed rectangle");
    };
}
