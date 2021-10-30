package decorator;

import javafx.scene.control.TextArea;

public class Bold extends TextStyleDecorator{

    private TextArea textArea;

    public Bold(TextStyle ts, TextArea textArea) {
        super(ts);
        this.textArea = textArea;
    }

    @Override
    public void setTextStyle(){
        super.setTextStyle();
        setTextBold();
    }

    public void setTextBold(){
        textArea.setStyle(textArea.getStyle()+"-fx-font-weight: 900;"+"-fx-font-size: 15px;");
    }
}

