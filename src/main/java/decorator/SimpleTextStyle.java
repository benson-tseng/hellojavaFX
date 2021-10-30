package decorator;

import javafx.scene.control.TextArea;

public class SimpleTextStyle implements TextStyle{
    private TextArea textArea;

    public SimpleTextStyle(TextArea ta){
        this.textArea = ta;
    }

    public void setTextStyle(){

    }
}
