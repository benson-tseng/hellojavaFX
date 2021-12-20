package Command;

public class CopyCommand implements Command{

    private TextEdit textEdit;

    //Set Receiver
    public CopyCommand(TextEdit textEdit){
        this.textEdit = textEdit;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        textEdit.copyCmd();
    }

    @Override
    public String getType() {
        return "edit";
    }
}
