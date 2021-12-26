package ChainOfResponsibility;

import Command.BlueCommand;
import Command.BoldCommand;
import Command.CleanCommand;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BoldHandler extends KeyHandler{
    private int count = 0;
    public BoldHandler (KeyHandler kHandler){super(kHandler);}

    //Ctrl B will do bold command
    @Override
    public void toHandle(KeyEvent event) {
        if (event.getCode() == KeyCode.B && event.isControlDown() ){
            count++;
            if (count % 2 == 1) {
                BoldCommand bold = new BoldCommand(super.getFontStyle());
                super.getCommandInvoker().execute(bold);
                System.out.println("Bold");
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
