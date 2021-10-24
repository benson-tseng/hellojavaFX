package strategy;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class DocMeth implements Meth{
    @Override
    public void editMeth(Scene scene, TextArea textArea){
        System.out.println("doc edit mode");
    }
}
