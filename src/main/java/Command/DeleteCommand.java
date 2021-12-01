package Command;


public class DeleteCommand implements Command{

    private TextEdit textEdit;

    //Set Receiver
    public DeleteCommand (TextEdit textEdit){
        this.textEdit = textEdit;
    }

    //Call Receiver to do
    public void execute(){
        textEdit.deleteCmd();
    }

}
