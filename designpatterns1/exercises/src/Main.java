import patterns.memento.Editor;
import patterns.memento.History;
import patterns.memento.worddoc.Document;
import patterns.memento.worddoc.DocumentHistory;

public class Main {
    public static void main(String[] args) {
        mementoExercisesTwo();
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
}