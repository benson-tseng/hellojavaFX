package ChainOfResponsibility;

import Command.CommandInvoker;
import Command.TextEdit;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public abstract class KeyHandler {

    protected KeyHandler kHandler;
    private CommandInvoker commandInvoker;
    private TextEdit textEdit;

    public KeyHandler (KeyHandler kHandler){
        this.kHandler = kHandler;
    }

    public void toNext(KeyEvent event){

        if (kHandler != null){
            kHandler.toHandle(event);
        }
    }

    public void setCmdInvoker(CommandInvoker commandInvoker){
        this.commandInvoker = commandInvoker;
    }

    public void setTextEdit(TextEdit textEdit){
        this.textEdit = textEdit;
    }

    public CommandInvoker getCommandInvoker(){
        return commandInvoker;
    }

    public TextEdit getTextEdit(){
        return this.textEdit;
    }

    public abstract void toHandle(KeyEvent event);


}
