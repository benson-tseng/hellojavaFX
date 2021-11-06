package Command;

public class PreviousCommand implements Command{
    private Combine combine;

    //Set Receiver
    public PreviousCommand (Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.previous();
    }
}
