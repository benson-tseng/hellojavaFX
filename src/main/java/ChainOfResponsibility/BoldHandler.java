package ChainOfResponsibility;

import Command.BoldCommand;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BoldHandler extends KeyHandler{

    public BoldHandler (KeyHandler kHandler){super(kHandler);}

    //Ctrl B will do bold command
    @Override
    public void toHandle(KeyEvent event) {
        if (event.getCode() == KeyCode.B && event.isControlDown() ){
            BoldCommand bold = new BoldCommand(super.getFontStyle());
            super.getCommandInvoker().execute(bold);
            System.out.println("Bold");
        } else {
            toNext(event);
        }

    }
}
