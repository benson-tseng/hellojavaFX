package Command;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveCommand implements Command{

    private TextArea textArea;

    public SaveCommand (TextArea textArea) {
        this.textArea = textArea;
    }

    // save file method
    @Override
    public void execute() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location To Save Report");
        File selectedFile = null;
        selectedFile = chooser.showSaveDialog(null);
//        while(selectedFile== null){
//            selectedFile = chooser.showSaveDialog(null);
//        }

        File file = new File(String.valueOf(selectedFile));
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        outFile.println(textArea.getText());
        outFile.close();
    }

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
