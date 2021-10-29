package com.example.hellojavafx;

import Command.Command;
import Command.CommandInvoker;
import Command.CloseCommand;
import Command.CopyCommand;
import Command.PasteCommand;
import Command.DeleteCommand;
import Command.OpenCommand;
import Command.SaveCommand;
import Command.SaveVersion;
import Command.PreviousCommand;
import Command.NextCommand;
import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Combine {
    CommandInvoker cmdImvoker;
    TextArea textArea;
    int curPosi;
    Originator originator;
    Caretaker caretaker;
    Memento m;

    final Clipboard clipboard ;
    final ClipboardContent content;

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

    public void closeCmd(){
        CloseCommand close = new CloseCommand();
        cmdImvoker.execute(close);
    }

    public void saveCmd(){
        SaveCommand save = new SaveCommand(textArea);
        cmdImvoker.execute(save);
    }

    public void openCmd(){
        OpenCommand open = new OpenCommand(textArea);
        cmdImvoker.execute(open);
    }

    public void copyCmd(){
        CopyCommand copy = new CopyCommand(textArea,clipboard,content,curPosi);
        cmdImvoker.execute(copy);
    }

    public void deleteCmd(){
        DeleteCommand del = new DeleteCommand(textArea,curPosi);
        cmdImvoker.execute(del);
    }

    public void pasteCmd(){
        PasteCommand paste = new PasteCommand(textArea,clipboard,curPosi);
        cmdImvoker.execute(paste);
    }

    public void undo(){
        cmdImvoker.undo();
    }

    public void redo(){
        cmdImvoker.redo();
    }

    public void saveVersion(){
        SaveVersion saveVer = new SaveVersion(textArea,originator,caretaker,m);
        cmdImvoker.execute(saveVer);
    }

    public void previous(){
        PreviousCommand previous = new PreviousCommand(textArea,originator,caretaker);
        cmdImvoker.execute(previous);
    }

    public void next(){
        NextCommand next = new NextCommand(textArea,originator,caretaker);
        cmdImvoker.execute(next);
    }

}
