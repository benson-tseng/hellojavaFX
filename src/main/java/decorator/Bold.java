package decorator;

import javafx.scene.control.TextArea;

public class Bold extends TextStyleDecorator{

    private TextArea textArea;

    public Bold(TextStyle ts, TextArea textArea) {
        super(ts);
        this.textArea = textArea;
    }

    //Get current style, then Set Bold Style plus on it.
    @Override
    public void setTextStyle(){
        super.setTextStyle();
        setTextBold();
    }
    //Set Bold style
    public void setTextBold(){
        textArea.setStyle(textArea.getStyle()+"-fx-font-weight: 900;"+"-fx-font-size: 15px;");
    }
}

