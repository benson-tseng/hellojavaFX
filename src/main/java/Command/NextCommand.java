package Command;

public class NextCommand implements Command{
    private Version version;

    //Set Receiver
    public NextCommand(Version version){
        this.version = version;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        version.next();
    }

}
