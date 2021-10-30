package Command;

import decorator.Blue;
import decorator.Bold;
import decorator.SimpleTextStyle;
import javafx.scene.control.TextArea;

public class BlueCommand implements Command{
    private TextArea textArea;

    public BlueCommand (TextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void execute() {
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

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
