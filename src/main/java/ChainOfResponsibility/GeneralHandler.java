package ChainOfResponsibility;

import Command.CommandInvoker;
import Command.CopyCommand;
import Command.TextEdit;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GeneralHandler extends KeyHandler{

    public GeneralHandler (KeyHandler kHandler){
        super(kHandler);
    }

    @Override
    public void toHandle(KeyEvent event) {
        if(event.isControlDown() == false){
            System.out.println(event.getCode());
        } else {
            toNext(event);
        }
    }

}
