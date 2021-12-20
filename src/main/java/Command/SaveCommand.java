package Command;

public class SaveCommand implements Command{
    private FileEdit fileEdit;

    //Set Receiver
    public SaveCommand (FileEdit fileEdit) {
        this.fileEdit = fileEdit;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        fileEdit.saveCmd();
    }

    @Override
    public String getType() {
        return null;
    }
}
