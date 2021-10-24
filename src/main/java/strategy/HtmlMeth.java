package strategy;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HtmlMeth implements Meth{
    @Override
    public void editMeth(Scene scene, TextArea textArea) {
        System.out.println("html edit");
        scene.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            int curPosi = textArea.getCaretPosition();
            StringBuffer sb = new StringBuffer(textArea.getText());
            if (event.getCode() == KeyCode.PERIOD && event.isShiftDown()) {
                for(int i = curPosi-2; i >= 0; i--){
                    if(textArea.getText().charAt(i)=='<'){
                        textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"</"+textArea.getText().subSequence(i+1, curPosi-1)+">")));
                        break;
                    }else if(textArea.getText().charAt(i) == '>'){
                        break;
                    }
                }
                textArea.positionCaret(curPosi);
            }
            if (event.getCode() == KeyCode.DIGIT9 && event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),")")));
                textArea.positionCaret(curPosi);
            }
            if (event.getCode() == KeyCode.QUOTE && event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"\"")));
                textArea.positionCaret(curPosi);
            }
            if (event.getCode() == KeyCode.QUOTE && !event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"\'")));
                textArea.positionCaret(curPosi);
            }
            if (event.getCode() == KeyCode.OPEN_BRACKET && !event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"]")));
                textArea.positionCaret(curPosi);
            }
            if (event.getCode() == KeyCode.OPEN_BRACKET && event.isShiftDown()){
                textArea.setText(String.valueOf(sb.insert(textArea.getCaretPosition(),"}")));
                textArea.positionCaret(curPosi);
            }
        });
    }
}
