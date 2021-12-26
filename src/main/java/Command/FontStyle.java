package Command;

import decorator.Blue;
import decorator.Bold;
import decorator.SimpleTextStyle;
import javafx.scene.control.TextArea;

//Receiver
public class FontStyle {

    private TextArea textArea;

    public FontStyle(TextArea textArea){
        this.textArea = textArea;
    }

    //Clean Style
    public void cleanStyle(){textArea.setStyle("");}

    // set Bold Style
    public void setBold(){
        if(textArea.getStyle() == ""){
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Bold b = new Bold(st,textArea);
            b.setTextStyle();
        }else {
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Blue i = new Blue(st,textArea);
            Bold b = new Bold(i,textArea);
            b.setTextStyle();
        }
    }

    // set Italic Style
    public void setBlue(){
        if(textArea.getStyle() == ""){
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Blue i = new Blue(st,textArea);
            i.setTextStyle();
        }else{
            SimpleTextStyle st = new SimpleTextStyle(textArea);
            Bold b = new Bold(st,textArea);
            Blue i = new Blue(b,textArea);
            i.setTextStyle();
        }
    }
}
