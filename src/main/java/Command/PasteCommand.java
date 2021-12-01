package Command;

public class PasteCommand implements Command{
    private TextEdit textEdit;

    //Set Receiver
    public PasteCommand(TextEdit textEdit){
        this.textEdit = textEdit;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        textEdit.pasteCmd();
    }
}
