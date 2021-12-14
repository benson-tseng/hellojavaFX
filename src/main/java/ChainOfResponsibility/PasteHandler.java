package ChainOfResponsibility;

import Command.CopyCommand;
import Command.PasteCommand;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PasteHandler extends KeyHandler{

    public PasteHandler (KeyHandler kHandler){
        super(kHandler);
    }

    @Override
    public void toHandle(KeyEvent event) {
        if(event.getCode() == KeyCode.V && event.isControlDown()){
            PasteCommand Paste = new PasteCommand(super.getTextEdit());
            super.getCommandInvoker().execute(Paste);
            System.out.println("paste");
        } else {
            toNext(event);
        }
    }
}
