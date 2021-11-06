package Command;

public class SaveCommand implements Command{
    private Combine combine;

    //Set Receiver
    public SaveCommand (Combine combine) {
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.saveCmd();
    }
}
