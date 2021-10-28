package Command;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class CopyCommand implements Command{

    @FXML
    private TextArea textArea;

    private int curPosi;

    final Clipboard clipboard ;
    final ClipboardContent content;

    //Let CopyCommand's TextArea & Clipboard & ClipboardConten & curPosi equals to Controller
    public CopyCommand(TextArea textArea, Clipboard clipboard, ClipboardContent content, int curPosi){
        this.textArea = textArea;
        this.clipboard = clipboard;
        this.content = content;
        this.curPosi = curPosi + textArea.getSelectedText().length();
    }

    //Put the selectedText on clipboard.
    @Override
    public void execute() {
        content.putString(textArea.getSelectedText());
        clipboard.setContent(content);
        textArea.positionCaret(curPosi);
    }

    //this.isReversible is return false, so no undo;
    @Override
    public void undo() {
        //Can not undo;
    }
    //We set Copy Command is not reversible.
    @Override
    public boolean isReversible() {
        return false;
    }

}
