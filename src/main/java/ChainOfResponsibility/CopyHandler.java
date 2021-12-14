package ChainOfResponsibility;

import Command.CommandInvoker;
import Command.CopyCommand;
import Command.TextEdit;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CopyHandler extends KeyHandler{

    public CopyHandler (KeyHandler kHandler){
        super(kHandler);
    }

    @Override
    public void toHandle(KeyEvent event) {
        if(event.getCode() == KeyCode.C && event.isControlDown()){
            CopyCommand copy = new CopyCommand(super.getTextEdit());
            super.getCommandInvoker().execute(copy);
            System.out.println("copy");
        } else {
            toNext(event);
        }
    }

}
