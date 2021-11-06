package Command;

public class CopyCommand implements Command{

    private Combine combine;

    //Set Receiver
    public CopyCommand(Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.copyCmd();
    }

}
