package Command;

public class NextCommand implements Command{
    private Combine combine;

    //Set Receiver
    public NextCommand(Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.next();
    }

}
