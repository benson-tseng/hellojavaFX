package ChainOfResponsibility;

import Command.BlueCommand;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.security.Key;

public class BlueHandler extends KeyHandler{

    public BlueHandler(KeyHandler kHandler) {super(kHandler);}

    //Ctrl E will do blue command
    @Override
    public void toHandle(KeyEvent event) {
        if (event.getCode() == KeyCode.E && event.isControlDown()){
            BlueCommand blue = new BlueCommand(super.getFontStyle());
            super.getCommandInvoker().execute(blue);
            System.out.println("Blue");
        } else {
            toNext(event);
        }
    }
}
