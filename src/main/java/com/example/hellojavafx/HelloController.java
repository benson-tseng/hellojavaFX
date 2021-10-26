package com.example.hellojavafx;

import interator.IntSet;
import interator.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import observer.TextLength;
import observer.TextObserver;
import strategy.CodeMeth;
import strategy.DocMeth;
import strategy.HtmlMeth;
import strategy.Meth;
import Command.CommandInvoker;
import Command.DeleteCommand;
import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;

import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;


public class HelloController {
    // document edit method
    private Meth meth;
    private Scene scene;
    private IntSet intSet;

    @FXML
    private TextField searchKeyWord;

    @FXML
    private TextArea textArea;

    @FXML
    private Text useMeth,
    resultNum,
    totalTextNum;

    @FXML
    private ComboBox chooseWord;

    CommandInvoker cmdInvoker;
    Originator originator;
    Caretaker caretaker;
    Memento m;

    public void initialize() {
        textArea.setWrapText(true);
        useMeth.setText("Doc Edit Mode");
        useMeth.setFont(Font.font(null, FontWeight.BLACK, 15));
        resultNum.setFont(Font.font(null, FontWeight.LIGHT, 15));
        totalTextNum.setFont(Font.font(null, FontWeight.BLACK, 15));
        chooseWord.setVisibleRowCount(5);
        cmdInvoker = new CommandInvoker();
        originator = new Originator();
        caretaker = new Caretaker();
        originator.setText(textArea.getText());
        m = originator.snapshot();
        caretaker.addMemento(m);
        setListener();
    }

    // count total text method
    public void totalText(){
        TextLength textLength = new TextLength();
        TextObserver viewer = new TextObserver("viewer",textArea,totalTextNum);
        viewer.subscribe(textLength);
        this.scene.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            textLength.inform();
        });
    }

    // set menu's option select listener
    public void setListener(){
        chooseWord.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                textArea.selectRange(intSet.getIntAt((Integer) number2),intSet.getIntAt((Integer) number2)+searchKeyWord.getLength());
            }
        });
    }

    // search word method
    public void searchWord(){
        StringBuffer sb = new StringBuffer(textArea.getText());
        this.intSet = new IntSet(1000);
        for(int i = 0; i <= this.textArea.getLength()-this.searchKeyWord.getLength();i++){
            if(sb.substring(i,i+this.searchKeyWord.getLength()).equals(this.searchKeyWord.getText())){
                intSet.appendInt(i);
            }
        }
        Iterator it = intSet.iterator();
        int countResult = 0;
        chooseWord.getItems().clear();
        while (it.hasNext()) {
            countResult+=1;
            int i = (int)it.next();
            chooseWord.getItems().add("Record "+countResult);
        }
        resultNum.setText(countResult + " Record");
    }

    // set scene which passed by Application
    public void setScene(Scene scene){
        this.scene = scene;
    }

    // use edit as Document file
    public void setDocMeth(){
        chooseMeth(new DocMeth());
        useMeth("Doc Edit Mode");
    }

    // use edit as Code file
    public void setCodeMeth(){
        chooseMeth(new CodeMeth());
        useMeth("Code Edit Mode");
    }

    // use edit as Html file
    public void setHtmlMeth(){
        chooseMeth(new HtmlMeth());
        useMeth("Html Edit Mode");
    }

    // init method & set current edit method
    public void useMeth(String s){
        if(meth == null){
            meth = new DocMeth();
        }
        meth.editMeth(scene,textArea);
        useMeth.setText(s);
    }

    // switch current method
    public void chooseMeth(Meth meth){
        this.meth = meth;
    }

    // save file method
    @FXML
    public void save() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location To Save Report");
        File selectedFile = null;
        while(selectedFile== null){
            selectedFile = chooser.showSaveDialog(null);
        }

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

    // open file method
    public void openFile() {
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

    public void onDelete(){
        DeleteCommand del = new DeleteCommand(textArea);
        cmdInvoker.execute(del);
    }

    public void undo(){
        cmdInvoker.undo();
    }

    public void redo(){
        cmdInvoker.redo();
    }

    public void saveVersion(){
        originator.setText(textArea.getText());
        m = originator.snapshot();
        caretaker.addMemento(m);
    }

    public void onPrevious(){
        originator.restore(caretaker.undo());
        textArea.setText(originator.getText());
    }

    public void onNext(){
        originator.restore(caretaker.redo());
        textArea.setText(originator.getText());
    }
    
}

// timer example
//    Timer = new Timer();
//    timer.schedule(task,0,100);
//    TimerTask task = new TimerTask()
//    {
//        @Override
//        public void run() {
//            if(textArea.getLength() >=1 && textArea.getText().charAt(textArea.getLength()-1) == '>'){
//                for(int i = textArea.getLength()-2; i >= 0; i--){
//                    if(textArea.getText().charAt(i)=='<'){
//                        textArea.setText(textArea.getText()+"</"+(String) textArea.getText().subSequence(i+1, textArea.getLength()-1)+">"+"\n");
//                    }
//                }
//                textArea.positionCaret(textArea.getLength());
//            }
//        }
//    };

// parse html
//    private String stripHTMLTags(String htmlText) {
//
//        Pattern = Pattern.compile("<[^>]*>");
//        Matcher matcher = pattern.matcher(htmlText);
//        final StringBuffer sb = new StringBuffer(htmlText.length());
//        while(matcher.find()) {
//            matcher.appendReplacement(sb, " ");
//        }
//        matcher.appendTail(sb);
//        return sb.toString().trim();
//
//    }

