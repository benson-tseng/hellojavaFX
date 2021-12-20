package Command;

public class PreviousCommand implements Command{
    private Version version;

    //Set Receiver
    public PreviousCommand (Version version){
        this.version = version;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        version.previous();
    }

    @Override
    public String getType() {
        return "ver";
    }
}
