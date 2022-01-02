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

    public KeyHandler (KeyHandler kHandler){
        this.kHandler = kHandler;
    }

    //Whether the current handler can handle and not null,otherwise call NextHandler to handle
    public void toNext(KeyEvent event){

        if (kHandler != null){
            kHandler.toHandle(event);
            kHandler.setCmdInvoker(commandInvoker);
            kHandler.setFontStyle(fontStyle);
        }
    }

    public abstract void toHandle(KeyEvent event);

    public void setCmdInvoker(CommandInvoker commandInvoker){
        this.commandInvoker = commandInvoker;
    }

    public void setFontStyle(FontStyle fontStyle) {this.fontStyle = fontStyle;}

    public CommandInvoker getCommandInvoker(){
        return this.commandInvoker;
    }

    public FontStyle getFontStyle() {return this.fontStyle;}
}
