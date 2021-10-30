package decorator;

import javafx.scene.control.TextArea;

public class Blue extends TextStyleDecorator{

    private TextArea textArea;

    public Blue(TextStyle ts, TextArea textArea) {
        super(ts);
        this.textArea = textArea;
    }

    @Override
    public void setTextStyle(){
        super.setTextStyle();
        setTextItalic();
    }

    public void setTextItalic(){
        textArea.setStyle(textArea.getStyle()+"-fx-text-fill: blue ;");
    }
}
