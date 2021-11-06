package Command;

public class BoldCommand implements Command{
    private Combine combine;

    //Set Receiver
    public BoldCommand (Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.setBold();
    }

}
