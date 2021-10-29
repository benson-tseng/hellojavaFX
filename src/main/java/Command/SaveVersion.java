package Command;

import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;

public class SaveVersion implements Command {
    private TextArea textArea;
    private Originator originator;
    private Caretaker caretaker;
    private Memento m;

    public SaveVersion (TextArea textArea, Originator originator, Caretaker caretaker, Memento m){
        this.textArea = textArea;
        this.originator = originator;
        this.caretaker = caretaker;
        this.m = m;
    }

    @Override
    public void execute() {
        originator.setText(textArea.getText());
        m = originator.snapshot();
        caretaker.addMemento(m);
    }

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
