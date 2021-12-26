package ChainOfResponsibility;

import Command.BlueCommand;
import Command.CleanCommand;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.security.Key;

public class BlueHandler extends KeyHandler{
    private int count = 0;
    public BlueHandler(KeyHandler kHandler) {super(kHandler);}

    //Ctrl E will do blue command
    @Override
    public void toHandle(KeyEvent event) {
        if (event.getCode() == KeyCode.E && event.isControlDown()){
            count++;
            if (count % 2 == 1) {
                BlueCommand blue = new BlueCommand(super.getFontStyle());
                super.getCommandInvoker().execute(blue);
                System.out.println("Blue");
            } else if (count % 2 == 0) {
                CleanCommand clean = new CleanCommand(super.getFontStyle());
                super.getCommandInvoker().execute(clean);
                System.out.println("Clean");
            }
        } else {
            count = 0;
            toNext(event);
        }
    }
}
