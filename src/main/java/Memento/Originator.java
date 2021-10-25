package Memento;

import javafx.scene.control.TextArea;

public class Originator extends TextArea {

    //Set Memento
    public void restore(Memento m){
        this.setText(m.getText());
    }

    //Save Current Version to new Memento;
    public Memento snapshot() {
        return new Memento(this.getText());
    }

}
