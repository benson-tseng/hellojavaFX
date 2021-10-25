package strategy;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CodeMeth implements Meth{
    public void editMeth(Scene scene, TextArea textArea){
        scene.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            int curPosi = textArea.getCaretPosition();
            StringBuffer sb = new StringBuffer(textArea.getText());

            // if user press 9 & shift at the same time, auto generate ")"
            if (event.getCode() == KeyCode.DIGIT9 && event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),")")));
                textArea.positionCaret(curPosi);
            }

            // if user press quote & shift at the same time, auto generate "\""
            if (event.getCode() == KeyCode.QUOTE && event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"\"")));
                textArea.positionCaret(curPosi);
            }

            // if user press quote, auto generate "\'"
            if (event.getCode() == KeyCode.QUOTE && !event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"\'")));
                textArea.positionCaret(curPosi);
            }

            // if user press open_bracket, auto generate "]"
            if (event.getCode() == KeyCode.OPEN_BRACKET && !event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"]")));
                textArea.positionCaret(curPosi);
            }

            // if user press open_bracket & shift at a same time, auto generate "}"
            if (event.getCode() == KeyCode.OPEN_BRACKET && event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"}")));
                textArea.positionCaret(curPosi);
            }
        });
    }
}
