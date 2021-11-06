package Command;

public class CleanCommand implements Command {
    private Combine combine;

    //Set Receiver
    public CleanCommand(Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.cleanStyle();
    }

}
