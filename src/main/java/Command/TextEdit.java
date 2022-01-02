package Command;

import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

//Receiver
public class TextEdit {

    private TextArea textArea;
    private Clipboard clipboard;
    private ClipboardContent content;
    private String tems;
    private int deleteIndex;
    private StringBuffer sb;

    public TextEdit(TextArea textArea,Clipboard clipboard,ClipboardContent content){
        this.textArea = textArea;
        this.clipboard = clipboard;
        this.content = content;
    }

    //Do Copy text
    public void copyCmd(){
        content.putString(textArea.getSelectedText());
        clipboard.setContent(content);
        textArea.positionCaret(textArea.getCaretPosition()+textArea.getSelectedText().length());
    }

    //Do Paste text
    public void pasteCmd(){
        int tmpCur = textArea.getCaretPosition();
        sb = new StringBuffer(textArea.getText());
        tems = textArea.getText();
        textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),clipboard.getString())));
        textArea.positionCaret(tmpCur+clipboard.getString().length());
    }
}
