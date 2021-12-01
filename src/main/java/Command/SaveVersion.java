package Command;

public class SaveVersion implements Command {

    private Version version;

    //Set Receiver
    public SaveVersion (Version version){
        this.version = version;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        version.saveVersion();
    }

}
