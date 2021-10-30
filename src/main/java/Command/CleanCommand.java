package Command;

import javafx.scene.control.TextArea;

public class CleanCommand implements Command {
    private TextArea textArea;

    public CleanCommand(TextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        textArea.setStyle("");
    }

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
