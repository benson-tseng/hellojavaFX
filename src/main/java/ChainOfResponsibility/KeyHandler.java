package ChainOfResponsibility;

import Command.CommandInvoker;
import Command.FontStyle;
import Command.TextEdit;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public abstract class KeyHandler {

    private KeyHandler kHandler;
    private CommandInvoker commandInvoker;
    private FontStyle fontStyle;
    private TextEdit textEdit;

    public KeyHandler (KeyHandler kHandler){
        this.kHandler = kHandler;
    }

    public void toNext(KeyEvent event){

        if (kHandler != null){
            kHandler.toHandle(event);
            kHandler.setCmdInvoker(commandInvoker);
            kHandler.setFontStyle(fontStyle);
        }
    }

    public void setCmdInvoker(CommandInvoker commandInvoker){
        this.commandInvoker = commandInvoker;
    }

    public void setFontStyle(FontStyle fontStyle) {this.fontStyle = fontStyle;}

    public CommandInvoker getCommandInvoker(){
        return this.commandInvoker;
    }

    public FontStyle getFontStyle() {return this.fontStyle;}

    public abstract void toHandle(KeyEvent event);


}
