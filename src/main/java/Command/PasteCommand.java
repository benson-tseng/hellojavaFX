package Command;

public class PasteCommand implements Command{
    private Combine combine;

    //Set Receiver
    public PasteCommand(Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.pasteCmd();
    }
}
