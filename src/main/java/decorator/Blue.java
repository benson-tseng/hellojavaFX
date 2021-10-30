package decorator;

import javafx.scene.control.TextArea;

public class Blue extends TextStyleDecorator{

    private TextArea textArea;

    public Blue(TextStyle ts, TextArea textArea) {
        super(ts);
        this.textArea = textArea;
    }

    //Get current style, then Set Blue Style plus on it.
    @Override
    public void setTextStyle(){
        super.setTextStyle();
        setTextItalic();
    }

    //Set Blue style
    public void setTextItalic(){
        textArea.setStyle(textArea.getStyle()+"-fx-text-fill: blue ;");
    }
}
