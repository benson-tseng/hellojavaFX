package Command;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class DeleteCommand implements Command{

    @FXML
    private TextArea textArea;

    private String tems;//Save the temporary String of TextArea
    private int deleteIndex;

    public DeleteCommand (TextArea TName){
        this.textArea = TName;

    }

    public void execute(){
        tems = textArea.getText();
        deleteIndex = textArea.getLength() - 1;

        if (deleteIndex >= 0) {
            textArea.setText(tems.substring(0,deleteIndex));//Retain text before the deleted char
        }
    }

    public void undo(){
        if (deleteIndex >= 0) {
            textArea.setText(tems);
        }
    }

    public boolean isReversible(){

        return true;

    }



}
