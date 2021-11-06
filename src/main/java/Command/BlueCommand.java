package Command;

public class BlueCommand implements Command{
    private Combine combine;

    //Set Receiver
    public BlueCommand (Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.setBlue();
    }

}
