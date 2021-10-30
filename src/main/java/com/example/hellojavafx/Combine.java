package com.example.hellojavafx;

import Command.CommandInvoker;
import Command.CopyCommand;
import Command.PasteCommand;
import Command.DeleteCommand;
import Command.OpenCommand;
import Command.SaveCommand;
import Command.SaveVersion;
import Command.PreviousCommand;
import Command.NextCommand;
import Command.CleanCommand;
import Command.BoldCommand;
import Command.BlueCommand;
import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class Combine {
    private CommandInvoker cmdImvoker;
    private TextArea textArea;
    private int curPosi;
    private Originator originator;
    private Caretaker caretaker;
    private Memento m;

    private final Clipboard clipboard ;
    private final ClipboardContent content;

    public Combine (CommandInvoker cmdImvoker, TextArea textArea, int curPosi, Clipboard clipboard, ClipboardContent content,Originator originator,Caretaker caretaker, Memento m){
        this.cmdImvoker = cmdImvoker;
        this.textArea = textArea;
        this.curPosi = curPosi;
        this.clipboard = clipboard;
        this.content = content;
        this.originator = originator;
        this.caretaker = caretaker;
        this.m = m;
    }

    //Save File
    public void saveCmd(){
        SaveCommand save = new SaveCommand(textArea);
        cmdImvoker.execute(save);
    }

    //Open File
    public void openCmd(){
        OpenCommand open = new OpenCommand(textArea);
        cmdImvoker.execute(open);
    }

    //Do Copy text
    public void copyCmd(){
        CopyCommand copy = new CopyCommand(textArea,clipboard,content,curPosi);
        cmdImvoker.execute(copy);
    }

    //Do Delete text
    public void deleteCmd(){
        DeleteCommand del = new DeleteCommand(textArea,curPosi);
        cmdImvoker.execute(del);
    }

    //Do Paste text
    public void pasteCmd(){
        PasteCommand paste = new PasteCommand(textArea,clipboard,curPosi);
        cmdImvoker.execute(paste);
    }

    //Return to the state before the command do
    public void undo(){
        cmdImvoker.undo();
    }

    //Return to the state before the command undo
    public void redo(){
        cmdImvoker.redo();
    }

    //Save Version at once
    public void saveVersion(){
        SaveVersion saveVer = new SaveVersion(textArea,originator,caretaker,m);
        cmdImvoker.execute(saveVer);
    }

    //Return to previous version
    public void previous(){
        PreviousCommand previous = new PreviousCommand(textArea,originator,caretaker);
        cmdImvoker.execute(previous);
    }

    //Return to latest version
    public void next(){
        NextCommand next = new NextCommand(textArea,originator,caretaker);
        cmdImvoker.execute(next);
    }

    //Clean Style
    public void cleanStyle(){
        CleanCommand clean = new CleanCommand(textArea);
        cmdImvoker.execute(clean);
    }

    // set Bold Style
    public void setBold(){
        BoldCommand bold = new BoldCommand(textArea);
        cmdImvoker.execute(bold);
    }

    // set Italic Style
    public void setBlue(){
        BlueCommand blue = new BlueCommand(textArea);
        cmdImvoker.execute(blue);
    }

}
