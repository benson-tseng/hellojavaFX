package Command;

public class OpenCommand implements Command{

    private Combine combine;

    //Set Receiver
    public OpenCommand (Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.openCmd();
    }

}



