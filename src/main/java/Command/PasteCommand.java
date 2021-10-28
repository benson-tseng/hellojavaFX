package Command;

import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;

public class PasteCommand implements Command{

    private TextArea textArea;

    private String tems;

    private int curPosi;

    StringBuffer sb;

    final Clipboard clipboard;

    //Let PasteCommand's TextArea & Clipboard & curPosi equals to Controller
    public PasteCommand(TextArea textArea, Clipboard clipboard, int curPosi){
        this.textArea = textArea;
        this.clipboard = clipboard;
        sb = new StringBuffer(textArea.getText());
        this.curPosi = curPosi + textArea.getSelectedText().length();
    }

    //Insert the clipboard's string on the textArea.
    @Override
    public void execute() {
        tems = textArea.getText();
        textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),clipboard.getString())));
        textArea.positionCaret(curPosi);
    }

    //Back to the textArea's text before Paste
    @Override
    public void undo() {
        textArea.setText(tems);
        textArea.positionCaret(curPosi);
    }

    //We set Paste Command is reversible.
    @Override
    public boolean isReversible() {
        return true;
    }
}
