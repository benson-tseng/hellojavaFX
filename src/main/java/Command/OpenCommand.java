package Command;

public class OpenCommand implements Command{

    private FileEdit fileEdit;

    //Set Receiver
    public OpenCommand (FileEdit fileEdit){
        this.fileEdit = fileEdit;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        fileEdit.openCmd();
    }

    @Override
    public String getType() {
        return null;
    }
}



