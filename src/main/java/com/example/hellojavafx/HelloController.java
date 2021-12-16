package com.example.hellojavafx;

import ChainOfResponsibility.GeneralHandler;
import ChainOfResponsibility.KeyHandler;
import ChainOfResponsibility.BoldHandler;
import ChainOfResponsibility.BlueHandler;
import Command.*;
import Facade.OViewFacade;
import Prototype.Emoji;
import Prototype.EmojiPrototype;
import bridge.ConcreteMailSender;
import bridge.GoogleSMTPServer;
import bridge.MailSender;
import bridge.SMTPServer;
import builder.Director;
import builder.EditBuilder;
import builder.MenuBarBuilder;
import builder.ReadOnlyBuilder;
import interator.IntSet;
import interator.Iterator;
import interpreter.*;
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
    private IContext iContext;

    private Menu MFile;
    private Menu MEditMethod;
    private Menu MTextEdit;
    private Menu MVersion;
    private Menu MStyle;

    @FXML
    private Label sendMailMsg;

    @FXML
    private TextField searchKeyWord, inputEmail;

    @FXML
    private TextArea textArea;

    @FXML
    private Button buttonJake;

    @FXML
    private Button buttonFinn;

    @FXML
    private Button buttonInit;

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
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    ;
    private final ClipboardContent content = new ClipboardContent();

    EditState editState = new EditState();
    ReadState readState = new ReadState();
    private Stage stage;

    private EmojiPrototype finn;
    private EmojiPrototype jake;
    private EmojiPrototype pika;
    private Emoji emojis;

    private KeyHandler handler;

    private OViewFacade oViewFacade;

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
        oViewFacade = new OViewFacade(textArea,searchKeyWord,inputEmail,useMeth,resultNum,totalTextNum,meth,scene,chooseWord,sendMailMsg);
        CreateMenu();
        handler = new BlueHandler (new BoldHandler(new GeneralHandler(null)));
        handler.setCmdInvoker(cmdInvoker);
        handler.setFontStyle(fontStyle);
        setListener();
        jake = new EmojiPrototype();
        jake.setEmoji("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１１１１１１１１１１１１１１１１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　１１１　　　１１１１１　　　　　　　　　　１１１１１　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　１１　　　１１　　　　　　　　１１　　　１１　　　　１１１　　　　　　　１１　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　１１　　　　　１１　１１１１　１１　　　　　１１　　　１１１　　　　　　１１　１１　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　１１　　　１１１１　　　　１１１１　　　１１　　　　１１１　　　　　　１１　　　１１　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　１１１１１　　　１１１１　　　１１１１１　　　　１１１　　　　　　１１　　　　１１　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　１１１　　　　　　１１　　１１　１１　１１　　１１　　　　　　１１１　　　　１１　　　　　　１１　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　１１１　　　　　１１　　１１１１　　１１１１　　１１　　　　　１１１　　１１　　　　１１１１　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　１１１１１　　　　１１　　１１　　　１１　　　１１　　１１　　　　１１１１１　　　　１１　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　１１　　　　　　　　　　１１１　　　　　　　　　　　　１１１　　　　　　　　　　　　１１　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　１１　　　　１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１１１　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　１１　　　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　１１　　　１１　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　１１　　　１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　１１　　　１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　１１　　１１１１　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１１　　　　　　　１１１１１１　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１１１　　　１１　　　　　　１１　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　　１１　　　　　１１　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　１１　　　　１１　　　　　１１　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　１１１１１　　　　　　　　１１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊\n");
        finn = new EmojiPrototype();
        finn.setEmoji("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊\n" +
                "　　　　　　　　　　　　　１１１１１１１１１　　　　　　　　　　　　　　　　　　　１１１１１１１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　１１１　　　　　　　　　　　　　　　　　１１１　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　１１１１１１１１１１１１１１１１１１１１１１１　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　１１１１１１１１１１１１１１１１１１１１１　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　１１１１　　　１１１　　　　１１　　　　　　　　　　　　　　　　　　　１１　　　　１１１　　　１１１１　　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　　１１　　　　　　　　　　　　　　　　　　　　　１１　　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　１１　　　　●　　　　　　　　　　　　　●　　　　１１　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　１１　　　　　　　　　　　　　　　　　　　　　　　１１　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　１１　　　　　　　　　　　　　　　　　　　　　　　１１　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　１１　　　　　　　＼＿＿＿＿＿＿＿／　　　　　　　１１　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　　１１　　　　　　　　　　　　　　　　　　　　　１１　　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　　　１１　　　　　　　　　　　　　　　　　　　１１　　　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　　　　１１１１１１１１１１１１１１１１１１１１１　　　　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　１１　　１１　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　１１　　１１　　　　　　　　　　　　＊\n" +
                "　　　　　　１１　　　１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１　　　１１　　　　　　　　　　　　　＊\n" +
                "　　　　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　１１１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１１１１１　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　１１１　　　　　　　　１１１１１１１１１　　　　　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　１１１　　　１１１　　　　　　　　　１１１　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　１１　　　１１　　　　　　　　　　　１１　　　１１　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　１１１１１　　　　　　　　　　　　　１１１１１　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１　１　　　　　　　　　　　　　　　１　１　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１　１　　　　　　　　　　　　　　　１　１　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　　　　　　１　１　　　　　　　　　　　　　　　１　１　　　　　　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　１１１１１１　１　　　　　　　　　　　　　　　１　１１１１１１　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　１１　　　　　　１　　　　　　　　　　　　　　　１　　　　　　１１　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "　　　　　　　　　　　　　　　　１１１１１１１　　　　　　　　　　　　　　　　　１１１１１１１　　　　　　　　　　　　　　　　　　　　　　　＊\n" +
                "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊\n");
        emojis = new Emoji();
        emojis.addPrototype("Finn", finn);
        emojis.addPrototype("Jake", jake);

        textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                handler.toHandle(event);
            }
        });
    }

    //Handle KeyEvent


    // create setTimeout func like js have
    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    // bridge sendMail function
    public void sendMail() {
        sendMailMsg.setStyle("-fx-text-fill: black;");
        sendMailMsg.setText("sending email ...");
        sendMailMsg.setVisible(true);

        // let "sending email" msg set first, then execute send mail function
        setTimeout(() -> {

            // create google smtp server & set it as concrete mail sender
            SMTPServer smtp = new GoogleSMTPServer();
            MailSender m = new ConcreteMailSender(smtp);

            // here fill in your gmail account & gmail application password
            int response = m.sendMail("google_acc", "google_application_pass", this.inputEmail.getText(), this.textArea.getText());

            if (response == 0) {
                sendMailMsg.setText("fail to send mail");
                sendMailMsg.setStyle("-fx-text-fill: red;");
                sendMailMsg.setVisible(true);
            } else if (response == 1) {
                sendMailMsg.setText("Successes");
                sendMailMsg.setStyle("-fx-text-fill: green;");
                sendMailMsg.setVisible(true);
            }
        }, 0);
    }

    // create menu
    public void CreateMenu() {
        Director director = new Director();
        //Set MenuItem combine OnAction depends on which command the MenuItem is.
        fileEdit = new FileEdit(textArea);
        textEdit = new TextEdit(textArea, clipboard, content);
        version = new Version(originator, m, caretaker, textArea);
        fontStyle = new FontStyle(textArea);
        MenuBarBuilder readOnly = new ReadOnlyBuilder(fileEdit, textEdit, version, fontStyle, cmdInvoker, context);
        MenuBarBuilder edit = new EditBuilder(fileEdit, textEdit, version, fontStyle, cmdInvoker, context);
        director.setMenuBarBuilder(edit);
        director.constructMenuBar();

        MenuBar tmpMenuBar = director.getMenuBar();

        for (int i = 0; i < director.getMenuBar().getMenus().size(); i++) {
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
    public void totalText() {
        TextLength textLength = new TextLength();
        TextObserver viewer = new TextObserver("viewer", textArea, totalTextNum);
        viewer.subscribe(textLength);
        this.scene.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            textLength.inform();
        });
    }

    // set menu's option select listener
    public void setListener() {
        chooseWord.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                // combo box default option is empty which index will be -1, it will cause the index out of bound error (ary[-1])
                // so make the default option to 0
                if(number2.toString().equals("-1")){
                    number2 = 0;
                }
                if (searchKeyWord.getText().charAt(0) == '^' || searchKeyWord.getText().charAt(searchKeyWord.getLength() - 1) == '$') {
                    textArea.selectRange((Integer) iContext.getSeqList().get((Integer) number2), (Integer) iContext.getSeqList().get((Integer) number2) + (iContext.getMap().get(iContext.getSeqList().get((Integer) number2))).toString().length());
                } else {
                    textArea.selectRange(intSet.getIntAt((Integer) number2), intSet.getIntAt((Integer) number2) + searchKeyWord.getLength());
                }
            }
        });
    }

    // search word method
    public void searchWord() {
        if (this.searchKeyWord.getText() != "") {
            int countResult;
            // use regexp search
            if (this.searchKeyWord.getText().charAt(0) == '^' && this.searchKeyWord.getText().substring(1, 2).matches("[a-zA-Z]") || this.searchKeyWord.getText().charAt(this.searchKeyWord.getLength() - 1) == '$' && this.searchKeyWord.getText().substring(this.searchKeyWord.getLength() - 2, this.searchKeyWord.getLength() - 1).matches("[a-zA-Z]")) {
                iContext = new IContext(this.searchKeyWord.getText());
                int tmpLength = 0;
                for (int i = 0; i < this.textArea.getText().split(" ").length; i++) {
                    if (this.textArea.getText().split(" ")[i].length() >= this.searchKeyWord.getText().length() - 2) {
                        iContext.addList(tmpLength);
                        iContext.addMap(tmpLength, this.textArea.getText().split(" ")[i]);
                    }
                    tmpLength += this.textArea.getText().split(" ")[i].length() + 1;
                }

                // if search key word start with "^"
                if (this.searchKeyWord.getText().charAt(0) == '^') {
                    regSearch(new ExpressionImplS());
                }
                // if search key word start with "$"
                if (this.searchKeyWord.getText().charAt(this.searchKeyWord.getLength() - 1) == '$') {
                    regSearch(new ExpressionImplE());
                }
                // if search key word have another word inside except ^word and word$
                if (this.searchKeyWord.getText().length() > 4) {
                    regSearch(new ExpressionImplA());
                }
            } else {
                // use general search
                StringBuffer sb = new StringBuffer(textArea.getText());
                this.intSet = new IntSet(1000);
                for (int i = 0; i <= this.textArea.getLength() - this.searchKeyWord.getLength(); i++) {
                    if (sb.substring(i, i + this.searchKeyWord.getLength()).equals(this.searchKeyWord.getText())) {
                        intSet.appendInt(i);
                    }
                }
                Iterator it = intSet.iterator();
                countResult = 0;
                chooseWord.getItems().clear();
                while (it.hasNext()) {
                    countResult += 1;
                    int i = (int) it.next();
                    chooseWord.getItems().add("Record " + countResult);
                }
                if (countResult == 0) {
                    resultNum.setText("No Record");
                } else {
                    resultNum.setText(countResult + " Record");
                }
                this.chooseWord.getSelectionModel().select(0);
            }
        } else {
            chooseWord.getItems().clear();
            resultNum.setText("Insert the keyword!");
        }
    }

    public void regSearch(Expression expression) {
        int countResult = 0;
        chooseWord.getItems().clear();
        if (expression.interpret(this.searchKeyWord.getText(), iContext)) {
            for (int i = 0; i < iContext.getSeqList().size(); i++) {
                countResult += 1;
                chooseWord.getItems().add("Record " + countResult);

            }
            resultNum.setText(countResult + " Record");
        } else {
            resultNum.setText("No Record");
        }
        this.chooseWord.getSelectionModel().select(0);
    }

    // set scene which passed by Application
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // use edit as Document file
    public void setDocMeth() {
        chooseMeth(new DocMeth());
        useMeth("Doc Edit Mode");
    }

    // use edit as Code file
    public void setCodeMeth() {
        chooseMeth(new CodeMeth());
        useMeth("Code Edit Mode");
    }

    // use edit as Html file
    public void setHtmlMeth() {
        chooseMeth(new HtmlMeth());
        useMeth("Html Edit Mode");
    }

    // init method & set current edit method
    public void useMeth(String s) {
        if (meth == null) {
            meth = new DocMeth();
        }
        meth.editMeth(scene, textArea);
        useMeth.setText(s);
    }

    // switch current method
    public void chooseMeth(Meth meth) {
        this.meth = meth;
    }

    // Print Emoji Finn
    public void PrintFinn(ActionEvent actionEvent) throws CloneNotSupportedException{
        EmojiPrototype finnPro = emojis.getPrototype("Finn");
        textArea.setText(textArea.getText() + finnPro.getEmoji());
        System.out.println("finn");
    }

    // Print Emoji Finn
    public void PrintJake(ActionEvent actionEvent) throws CloneNotSupportedException{
        EmojiPrototype jakePro = emojis.getPrototype("Jake");
        textArea.setText(textArea.getText() + jakePro.getEmoji());
        System.out.println("finn");
    }

    // Init View
    public void InitView(ActionEvent actionEvent) {
        oViewFacade.init();
    }

//    public void toggleButton(ActionEvent actionEvent) throws CloneNotSupportedException {
//        if (actionEvent.getSource() == buttonJake) {
//            EmojiPrototype jakePro = emojis.getPrototype("Jake");
//            textArea.setText(textArea.getText() + jakePro.getEmoji());
//            System.out.println("jake");
//        } else if (actionEvent.getSource() == buttonFinn) {
//            EmojiPrototype finnPro = emojis.getPrototype("Finn");
//            textArea.setText(textArea.getText() + finnPro.getEmoji());
//            System.out.println("finn");
//        }
//    }
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
