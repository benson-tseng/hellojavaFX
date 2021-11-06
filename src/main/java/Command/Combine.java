package Command;

import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;
import decorator.Blue;
import decorator.Bold;
import decorator.SimpleTextStyle;
import javafx.concurrent.Task;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Combine {
    private CommandInvoker cmdImvoker;
    private TextArea textArea;
    private int curPosi;
    private Originator originator;
    private Caretaker caretaker;
    private Memento m;
    private String tems;//Save the temporary String of TextArea
    private int deleteIndex;
    private StringBuffer sb;

    private final Clipboard clipboard ;
    private final ClipboardContent content;

    public Combine (CommandInvoker cmdImvoker, TextArea textArea, int curPosit, Clipboard clipboard,
                    ClipboardContent content,Originator originator,Caretaker caretaker, Memento m){
        this.cmdImvoker = cmdImvoker;
        this.textArea = textArea;
        this.curPosi = curPosit;
        this.clipboard = clipboard;
        this.content = content;
        this.originator = originator;
        this.caretaker = caretaker;
        this.m = m;
    }

    //Save File
    public void saveCmd(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location To Save Report");
        File selectedFile = null;
        selectedFile = chooser.showSaveDialog(null);

        File file = new File(String.valueOf(selectedFile));
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        outFile.println(textArea.getText());
        outFile.close();

    }

    //Open File
    public void openCmd(){
        FileChooser fileChooser = new FileChooser();

        //only allow text files to be selected using chooser
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
        );

        //set initial directory somewhere user will recognise
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        //let user select file
        File fileToLoad = fileChooser.showOpenDialog(null);

        //if file has been chosen, load it using asynchronous method (define later)
        if (fileToLoad != null) {
            loadFileToTextArea(fileToLoad);
        }

    }

    //Do Copy text
    public void copyCmd(){
        content.putString(textArea.getSelectedText());
        clipboard.setContent(content);
        textArea.positionCaret(textArea.getCaretPosition()+textArea.getSelectedText().length());
    }

    //Do Delete text
    public void deleteCmd(){
        int i = textArea.getCaretPosition();
        tems = textArea.getText();
        deleteIndex = textArea.getCaretPosition();
        if (deleteIndex >= 0) {
            textArea.setText(tems.substring(0,deleteIndex) +
                    //Retain text before the deleted char
                    tems.substring(deleteIndex+textArea.getSelectedText().length(),textArea.getLength()));
        }
        textArea.positionCaret(i);
    }

    //Do Paste text
    public void pasteCmd(){
        int tmpCur = textArea.getCaretPosition();
        sb = new StringBuffer(textArea.getText());
        tems = textArea.getText();
        textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),clipboard.getString())));
        textArea.positionCaret(tmpCur+clipboard.getString().length());
    }

    //Save Version at once
    public void saveVersion(){
        originator = new Originator(textArea.getText());
        m = originator.snapshot();
        caretaker.addMemento(m);
    }

    //Return to previous version
    public void previous(){
        originator.restore(caretaker.undo());
        textArea.setText(originator.getTextStates());
    }

    //Return to latest version
    public void next(){
        originator.restore(caretaker.redo());
        textArea.setText(originator.getTextStates());
    }

    //Clean Style
    public void cleanStyle(){textArea.setStyle("");}

    // set Bold Style
    public void setBold(){
        if(textArea.getStyle() == ""){
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Bold b = new Bold(st,textArea);
            b.setTextStyle();
        }else {
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Blue i = new Blue(st,textArea);
            Bold b = new Bold(i,textArea);
            b.setTextStyle();
        }
    }

    // set Italic Style
    public void setBlue(){
        if(textArea.getStyle() == ""){
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Blue i = new Blue(st,textArea);
            i.setTextStyle();
        }else{
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Bold b = new Bold(st,textArea);
            Blue i = new Blue(b,textArea);
            i.setTextStyle();
        }
    }

    private void loadFileToTextArea(File fileToLoad) {
        Task<String> loadTask = fileLoaderTask(fileToLoad);
        loadTask.run();
    }

    private Task<String> fileLoaderTask(File fileToLoad) {
        //Create a task to load the file asynchronously
        Task<String> loadFileTask = new Task<>() {
            @Override
            protected String call() throws Exception {
                BufferedReader reader = new BufferedReader(new FileReader(fileToLoad));
                //Use Files.lines() to calculate total lines - used for progress
                long lineCount;
                try (Stream<String> stream = Files.lines(fileToLoad.toPath())) {
                    lineCount = stream.count();
                }

                //Load in all lines one by one into a StringBuilder separated by "\n" - compatible with TextArea
                String line;
                StringBuilder totalFile = new StringBuilder();
                long linesLoaded = 0;
                while ((line = reader.readLine()) != null) {
                    totalFile.append(line);
                    totalFile.append("\n");
                    updateProgress(++linesLoaded, lineCount);
                }
                return totalFile.toString();
            }
        };
        //If successful, update the text area, display a success message and store the loaded file reference
        loadFileTask.setOnSucceeded(workerStateEvent -> {
            try {
                textArea.setText(loadFileTask.get());
            } catch (InterruptedException | ExecutionException e) {
                textArea.setText("Could not load file from:\n " + fileToLoad.getAbsolutePath());
            }
        });
        //If unsuccessful, set text area with error message and status message to failed
        loadFileTask.setOnFailed(workerStateEvent -> {
            textArea.setText("Could not load file from:\n " + fileToLoad.getAbsolutePath());
        });
        return loadFileTask;
    }
}

