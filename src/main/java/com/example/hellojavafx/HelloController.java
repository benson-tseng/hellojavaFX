package com.example.hellojavafx;

import Command.*;
import Prototype.Prototype;
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
import Prototype.JakeEmoji;
import Prototype.FinnEmoji;


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
    private ToggleButton buttonJake;

    @FXML
    private ToggleButton buttonFinn;

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

    private FileEdit fileEdit;
    private TextEdit textEdit;
    private Version version;
    private FontStyle fontStyle;

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

    private JakeEmoji jakeEmoji;
    private FinnEmoji finnEmoji;

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
        jakeEmoji = new JakeEmoji();
        finnEmoji = new FinnEmoji();
        context = new Context();
        CreateMenu();
        setListener();
    }

    // create menu
    public void CreateMenu(){
        Director director = new Director();
        //Set MenuItem combine OnAction depends on which command the MenuItem is.
        fileEdit = new FileEdit(textArea);
        textEdit = new TextEdit(textArea,clipboard,content);
        version = new Version(originator,m,caretaker,textArea);
        fontStyle = new FontStyle(textArea);
        MenuBarBuilder readOnly = new ReadOnlyBuilder(fileEdit,textEdit,version,fontStyle,cmdInvoker,context);
        MenuBarBuilder edit = new EditBuilder(fileEdit,textEdit,version,fontStyle,cmdInvoker,context);
        director.setMenuBarBuilder(edit);
        director.constructMenuBar();

        MenuBar tmpMenuBar = director.getMenuBar();

        for(int i = 0; i < director.getMenuBar().getMenus().size(); i++){
            menuBar.getMenus().add(tmpMenuBar.getMenus().get(i));
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
            chooseWord.getItems().clear();
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

    // Print Emoji
    public void toggleButton(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonJake) {
            Prototype p = jakeEmoji.clone();
            textArea.setText(p.getEmoji());
            System.out.println("jake");
        } else if (actionEvent.getSource() == buttonFinn) {
            Prototype p = finnEmoji.clone();
            textArea.setText(p.getEmoji());
            System.out.println("finn");
        }
    }
}

//menuBar.getMenus().clear();
//        if (actionEvent.getSource() == buttonEditor) {
//        editState.doAction(context);
//
//    } else if (actionEvent.getSource() == buttonReader) {
//        readState.doAction(context);
//
//    }
//
//    //Set MenuItem combine OnAction depends on which command the MenuItem is.
//    fileEdit = new FileEdit(textArea);
//    textEdit = new TextEdit(textArea,clipboard,content);
//    version = new Version(originator,m,caretaker,textArea);
//    fontStyle = new FontStyle(textArea);
//        if (context.getState() == editState){
//        Director director = new Director();
//        System.out.println(1);
//        System.out.println(textArea.getCaretPosition());
//        MenuBarBuilder edit = new EditBuilder(fileEdit,textEdit,version,fontStyle,cmdInvoker,context);
//        director.setMenuBarBuilder(edit);
//        director.constructMenuBar();
//
//        for(int i = 0; i < director.getMenuBar().getMenus().size(); i++){
//            menuBar.getMenus().add(director.getMenuBar().getMenus().get(i));
//        }
//
//        MFile = menuBar.getMenus().get(0);
//        MEditMethod = menuBar.getMenus().get(1);
//        MTextEdit = menuBar.getMenus().get(2);
//        MVersion = menuBar.getMenus().get(3);
//        MStyle = menuBar.getMenus().get(4);
//        textArea.setEditable(true);
//
//        MEditMethod.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                setDocMeth();
//            }
//        });
//
//        MEditMethod.getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                setCodeMeth();
//            }
//        });
//
//        MEditMethod.getItems().get(2).setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                setHtmlMeth();
//            }
//        });
//    } else if (context.getState() == readState){
//        Director director = new Director();
//        System.out.println(1);
//        System.out.println(textArea.getCaretPosition());
//        MenuBarBuilder read = new ReadOnlyBuilder(fileEdit,textEdit,version,fontStyle,cmdInvoker,context);
//        director.setMenuBarBuilder(read);
//        director.constructMenuBar();
//
//        for(int i = 0; i < director.getMenuBar().getMenus().size(); i++){
//            menuBar.getMenus().add(director.getMenuBar().getMenus().get(i));
//        }
//
//        MFile = menuBar.getMenus().get(0);
//        textArea.setEditable(false);
//    }
//
//    //Close the window
//        MFile.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
//        @Override
//        public void handle(ActionEvent event) {
//            stage.close();
//        }
//    });
//}
