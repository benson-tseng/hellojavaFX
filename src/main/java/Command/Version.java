package Command;

import Memento.Memento;
import Memento.Originator;
import Memento.Caretaker;
import javafx.scene.control.TextArea;

public class Version {

    private Originator originator;
    private Memento m;
    private Caretaker caretaker;
    private TextArea textArea;

    public Version(Originator originator,Memento m,Caretaker caretaker,TextArea textArea){
        this.originator = originator;
        this.m = m;
        this.caretaker = caretaker;
        this.textArea = textArea;
    }

    //Save Version at once
    public void saveVersion(){
        originator = new Originator(textArea.getText());
        m = originator.snapshot();
        caretaker.addMemento(m);
    }

    //Return to previous version
    public void previous(){
        originator.restore(caretaker.undo());
        textArea.setText(originator.getTextStates());
    }

    //Return to latest version
    public void next(){
        originator.restore(caretaker.redo());
        textArea.setText(originator.getTextStates());
    }
}
