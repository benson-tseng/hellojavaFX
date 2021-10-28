package Command;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class DeleteCommand implements Command{

    @FXML
    private TextArea textArea;

    private String tems;//Save the temporary String of TextArea
    private int deleteIndex;
    private int curPosi;

    ////Let DeleteCommand's TextArea & curPosi equals to Controller
    public DeleteCommand (TextArea TName,int curPosi){
        this.textArea = TName;
        this.curPosi = curPosi + textArea.getSelectedText().length();
    }

    public void execute(){
        tems = textArea.getText();
        deleteIndex = textArea.getLength() - 1;

        if (deleteIndex >= 0) {
            textArea.setText(tems.substring(0,deleteIndex));//Retain text before the deleted char
        }
        textArea.positionCaret(curPosi);
    }

    public void undo(){
        if (deleteIndex >= 0) {
            textArea.setText(tems);
        }
        textArea.positionCaret(curPosi );
    }

    public boolean isReversible(){

        return true;

    }

}
