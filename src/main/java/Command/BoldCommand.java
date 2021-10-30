package Command;

import decorator.Blue;
import decorator.Bold;
import decorator.SimpleTextStyle;
import javafx.scene.control.TextArea;

public class BoldCommand implements Command{
    private TextArea textArea;
    private Bold b;
    private Blue i;

    public BoldCommand (TextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void execute() {
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

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
