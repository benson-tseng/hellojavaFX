package com.example.hellojavafx;

import Command.*;
import builder.Director;
import builder.EditBuilder;
import builder.MenuBarBuilder;
import builder.ReadOnlyBuilder;
import interator.IntSet;
import interator.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import observer.TextLength;
import observer.TextObserver;
import strategy.CodeMeth;
import strategy.DocMeth;
import strategy.HtmlMeth;
import strategy.Meth;
import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;
import State.ReadState;
import State.EditState;
import State.Context;


public class HelloController {
    // document edit method
    private Meth meth;
    private Scene scene;
    private IntSet intSet;

    private Menu MFile;
    private Menu MEditMethod;
    private Menu MTextEdit;
    private Menu MVersion;
    private Menu MStyle;

    @FXML
    private TextField searchKeyWord;

    @FXML
    private TextArea textArea;

    @FXML
    private ToggleButton buttonEditor;

    @FXML
    private ToggleButton buttonReader;

    @FXML
    private Text useMeth,
    resultNum,
    totalTextNum;

    @FXML
    private ComboBox chooseWord;

    // Position in TextArea;
    private int curPosi;

    @FXML
    private MenuBar menuBar;

    // CommandInvoker use to invoke command;
    private CommandInvoker cmdInvoker;

    private Combine combine;

    // Memento participant
    private Originator originator;
    private Caretaker caretaker;
    private Memento m;

    // An outwindow
    private Context context;

    // Copy & Paste need to use
    private final Clipboard clipboard = Clipboard.getSystemClipboard();;
    private final ClipboardContent content = new ClipboardContent();

    EditState editState = new EditState();
    ReadState readState = new ReadState();
    private Stage stage;

    public void initialize() throws NoSuchMethodException {
        textArea.setWrapText(true);
        useMeth.setText("Doc Edit Mode");
        useMeth.setFont(Font.font(null, FontWeight.BLACK, 15));
        resultNum.setFont(Font.font(null, FontWeight.LIGHT, 15));
        totalTextNum.setFont(Font.font(null, FontWeight.BLACK, 15));
        chooseWord.setVisibleRowCount(5);
        cmdInvoker = CommandInvoker.getInstance();
        originator = new Originator(textArea.getText());
        caretaker = new Caretaker();
        m = originator.snapshot();
        caretaker.addMemento(m);
        context = new Context();
        CreateMenu();


        setListener();

    }

    //test
    public void CreateMenu() throws NoSuchMethodException {
        Director director = new Director();
        //Set MenuItem combine OnAction depends on which command the MenuItem is.
        combine = new Combine(cmdInvoker,textArea,curPosi,clipboard,content,originator,caretaker,m);
        MenuBarBuilder edit = new EditBuilder(combine,cmdInvoker,context);
        director.setMenuBarBuilder(edit);
        director.constructMenuBar();

        for(int i = 0; i < director.getMenuBar().getMenus().size(); i++){
            menuBar.getMenus().add(director.getMenuBar().getMenus().get(i));
        }

        MFile = menuBar.getMenus().get(0);
        MEditMethod = menuBar.getMenus().get(1);
        MTextEdit = menuBar.getMenus().get(2);
        MVersion = menuBar.getMenus().get(3);
        MStyle = menuBar.getMenus().get(4);

        MEditMethod.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setDocMeth();
            }
        });

        MEditMethod.getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCodeMeth();
            }
        });

        MEditMethod.getItems().get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setHtmlMeth();
            }
        });
        //Close the window
        MFile.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });






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
        if(this.searchKeyWord.getText() != ""){
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
        }else{
            resultNum.setText("Insert the keyword!");
        }
    }

    // set scene which passed by Application
    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void setStage(Stage stage){
        this.stage = stage;
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

    // Change to Editor or Reader
    public void toggleButton(ActionEvent actionEvent){
        menuBar.getMenus().clear();
        if (actionEvent.getSource() == buttonEditor) {
            editState.doAction(context);

        } else if (actionEvent.getSource() == buttonReader) {
            ReadState read = new ReadState();
            readState.doAction(context);

        }

        //Set MenuItem combine OnAction depends on which command the MenuItem is.
        combine = new Combine(cmdInvoker,textArea,curPosi,clipboard,content,originator,caretaker,m);
        if (context.getState() == editState){
            Director director = new Director();
            System.out.println(1);
            System.out.println(textArea.getCaretPosition());
            MenuBarBuilder edit = new EditBuilder(combine,cmdInvoker,context);
            director.setMenuBarBuilder(edit);
            director.constructMenuBar();

            for(int i = 0; i < director.getMenuBar().getMenus().size(); i++){
                menuBar.getMenus().add(director.getMenuBar().getMenus().get(i));
            }

            MFile = menuBar.getMenus().get(0);
            MEditMethod = menuBar.getMenus().get(1);
            MTextEdit = menuBar.getMenus().get(2);
            MVersion = menuBar.getMenus().get(3);
            MStyle = menuBar.getMenus().get(4);

            MEditMethod.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setDocMeth();
                }
            });

            MEditMethod.getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setCodeMeth();
                }
            });

            MEditMethod.getItems().get(2).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setHtmlMeth();
                }
            });
        } else if (context.getState() == readState){
            Director director = new Director();
            System.out.println(1);
            System.out.println(textArea.getCaretPosition());
            MenuBarBuilder read = new ReadOnlyBuilder(combine,cmdInvoker,context);
            director.setMenuBarBuilder(read);
            director.constructMenuBar();

            for(int i = 0; i < director.getMenuBar().getMenus().size(); i++){
                menuBar.getMenus().add(director.getMenuBar().getMenus().get(i));
            }

            MFile = menuBar.getMenus().get(0);
        }



        //Close the window
        MFile.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
    }

}

//    // clean style
//    public void cleanStyle(){
//        textArea.setStyle("");
//    }
//
//    // set Bold Style
//    public void setBold(){
//        if(textArea.getStyle() == ""){
//            SimpleTextStyle st = new SimpleTextStyle(textArea);
//            Bold b = new Bold(st,textArea);
//            b.setTextStyle();
//        }else{
//            SimpleTextStyle st = new SimpleTextStyle(textArea);
//            Blue i = new Blue(st,textArea);
//            Bold b = new Bold(i,textArea);
//            b.setTextStyle();
//        }
//    }
//    // set Italic Style
//    public void setBlue(){
//        if(textArea.getStyle() == ""){
//            SimpleTextStyle st = new SimpleTextStyle(textArea);
//            Blue i = new Blue(st,textArea);
//            i.setTextStyle();
//        }else{
//            SimpleTextStyle st = new SimpleTextStyle(textArea);
//            Bold b = new Bold(st,textArea);
//            Blue i = new Blue(b,textArea);
//            i.setTextStyle();
//        }
//    }
// save file method
//    @FXML
//    public void save() {
//        FileChooser chooser = new FileChooser();
//        chooser.setTitle("Choose location To Save Report");
//        File selectedFile = null;
//        selectedFile = chooser.showSaveDialog(null);
////        while(selectedFile== null){
////            selectedFile = chooser.showSaveDialog(null);
////        }
//
//        File file = new File(String.valueOf(selectedFile));
//        PrintWriter outFile = null;
//        try {
//            outFile = new PrintWriter(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        outFile.println(textArea.getText());
//        outFile.close();
//    }
//
//    // open file method
//    public void openFile() {
//        FileChooser fileChooser = new FileChooser();
//
//        //only allow text files to be selected using chooser
//        fileChooser.getExtensionFilters().add(
//                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
//        );
//
//        //set initial directory somewhere user will recognise
//        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//
//        //let user select file
//        File fileToLoad = fileChooser.showOpenDialog(null);
//
//        //if file has been chosen, load it using asynchronous method (define later)
//        if (fileToLoad != null) {
//            loadFileToTextArea(fileToLoad);
//        }
//    }
//
//    private void loadFileToTextArea(File fileToLoad) {
//        Task<String> loadTask = fileLoaderTask(fileToLoad);
//        loadTask.run();
//    }
//
//    private Task<String> fileLoaderTask(File fileToLoad) {
//        //Create a task to load the file asynchronously
//        Task<String> loadFileTask = new Task<>() {
//            @Override
//            protected String call() throws Exception {
//                BufferedReader reader = new BufferedReader(new FileReader(fileToLoad));
//
//                //Use Files.lines() to calculate total lines - used for progress
//                long lineCount;
//                try (Stream<String> stream = Files.lines(fileToLoad.toPath())) {
//                    lineCount = stream.count();
//                }
//
//                //Load in all lines one by one into a StringBuilder separated by "\n" - compatible with TextArea
//                String line;
//                StringBuilder totalFile = new StringBuilder();
//                long linesLoaded = 0;
//                while ((line = reader.readLine()) != null) {
//                    totalFile.append(line);
//                    totalFile.append("\n");
//                    updateProgress(++linesLoaded, lineCount);
//                }
//
//                return totalFile.toString();
//            }
//        };
//
//        //If successful, update the text area, display a success message and store the loaded file reference
//        loadFileTask.setOnSucceeded(workerStateEvent -> {
//            try {
//                textArea.setText(loadFileTask.get());
//            } catch (InterruptedException | ExecutionException e) {
//                textArea.setText("Could not load file from:\n " + fileToLoad.getAbsolutePath());
//            }
//        });
//
//        //If unsuccessful, set text area with error message and status message to failed
//        loadFileTask.setOnFailed(workerStateEvent -> {
//            textArea.setText("Could not load file from:\n " + fileToLoad.getAbsolutePath());
//        });
//
//        return loadFileTask;
//    }
//
//    public void onCopy(){
//        CopyCommand cop = new CopyCommand(textArea,clipboard,content,curPosi);
//        cmdInvoker.execute(cop);
//
//    }
//
//    // Do PasteCommand
//    public void onPaste(){
//        PasteCommand pas = new PasteCommand(textArea,clipboard,curPosi);
//        cmdInvoker.execute(pas);
//    }
//
//    // Do DeleteCommand
//    public void onDelete(){
//        DeleteCommand del = new DeleteCommand(textArea,curPosi);
//        cmdInvoker.execute(del);
//    }
//
//    // Back to before the last Command execute or Cancel Redo
//    public void undo(){
//        cmdInvoker.undo();
//    }
//
//    // Cancel Undo
//    public void redo(){
//        cmdInvoker.redo();
//    }
//
//    // Save Version
//    public void saveVersion(){
//        originator.setText(textArea.getText());
//        m = originator.snapshot();
//        caretaker.addMemento(m);
//    }
//
//    // Back to Previous Version
//    public void onPrevious(){
//        originator.restore(caretaker.undo());
//        textArea.setText(originator.getText());
//    }
//
//    // Cancel Back to Previous Version
//    public void onNext(){
//        originator.restore(caretaker.redo());
//        textArea.setText(originator.getText());
//    }
// -------------------1030------------------------------
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

