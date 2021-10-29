package Command;

import Memento.Caretaker;
import Memento.Originator;
import javafx.scene.control.TextArea;

public class NextCommand implements Command{
    private TextArea textArea;
    private Caretaker caretaker;
    private Originator originator;

    public NextCommand(TextArea textArea,Originator originator,Caretaker caretaker){
        this.textArea = textArea;
        this.originator = originator;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        originator.restore(caretaker.redo());
        textArea.setText(originator.getText());
    }

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
