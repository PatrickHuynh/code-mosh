import patterns.memento.Editor;
import patterns.memento.History;
import patterns.memento.worddoc.Document;
import patterns.memento.worddoc.DocumentHistory;
import patterns.state.*;
import patterns.state.mapping.DirectionService;
import patterns.state.mapping.TravelMode;
import patterns.state.mapping.TravelModeBicycle;
import patterns.state.mapping.TravelModeDriving;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //mementoExercisesTwo();
        //stateExerciseOne();
        stateExerciseTwo();
    }

    public static void mementoExercises(){
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");

        history.push(editor.createState());
        editor.setContent("b");

        history.push(editor.createState());
        editor.setContent("c");

        System.out.println(editor.getContent());
        editor.restore(history.pop());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }

    public static void mementoExercisesTwo(){
        var doc = new Document();
        var docHistory = new DocumentHistory();

        docHistory.push(doc.createState());
        doc.setContent("Hello World!");

        docHistory.push(doc.createState());
        doc.setFontName("Arial");

        docHistory.push(doc.createState());
        doc.setFontSize(18);

        System.out.println(doc.createState().toString());
        doc.restore(docHistory.pop());
        System.out.println(doc.createState().toString());
        doc.restore(docHistory.pop());
        System.out.println(doc.createState().toString());
        doc.restore(docHistory.pop());
        System.out.println(doc.createState().toString());
        doc.restore(docHistory.pop());

        // Excercise notes future variables could be added to document class
        // haven't done it - but the solution would be to refactor the state
        // to be stored in a hashmap such that it could be extended with
        // new keyword fields
    }

    public static void stateExerciseOne(){
        var canvas = new Canvas();

        List<Tool> toolList = new ArrayList<>();
        toolList.add(new ToolSelection());
        toolList.add(new ToolBrush());
        toolList.add(new ToolEraser());

        for (var tool : toolList) {
            canvas.setCurrentTool(tool);
            canvas.mouseDown();
            canvas.mouseUp();
        }
    }

    public static void stateExerciseTwo(){
    // In the Exercises project, look at the code in the state/DirectionService class.
    // This is the class that powers our mapping app.
    // It provides two methods for calculating the estimated time of arrival (ETA) and the direction between two points.
    // Identify the problems in this implementation.
        // getEta and getDirection have repeated logic. If new features added, repeated code is hard to maintain.
    // Then, refactor the code to use the state pattern.
    // What are the benefits of the new implementation?
        // don't have to modify existing classes with new features, can just extend code.
    var app = new DirectionService();
    List<TravelMode> travelModes = new ArrayList<>();
    travelModes.add(new TravelModeDriving());
    travelModes.add(new TravelModeBicycle());
        for (var tm : travelModes){
            app.setTravelMode(tm);
            System.out.println(app.getDirection());
            System.out.println(app.getEta());
        }
    }
}
