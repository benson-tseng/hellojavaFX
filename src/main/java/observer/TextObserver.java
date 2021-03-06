package observer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class TextObserver implements Observer{
    private String name = null;
    private Observable text = null;
    private TextArea textArea;
    private Text totalTextNum;

    public TextObserver(String name,TextArea textArea,Text text){
        this.name = name;
        this.textArea = textArea;
        this.totalTextNum = text;
    }

    // subscribe textLength
    public void subscribe(Observable text) {
        this.text = text;
        text.register(this);
    }

    // unsubscribe textLength
    @Override
    public void unsubscribe() {
        text.unregister(this);
    }

    // update the total word
    @Override
    public void update() {
        totalTextNum.setText("Total "+textArea.getLength()+" Word");
    }
}
