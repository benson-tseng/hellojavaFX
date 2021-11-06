package Command;

public class SaveVersion implements Command {

    private Combine combine;

    //Set Receiver
    public SaveVersion (Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        combine.saveVersion();
    }

}
