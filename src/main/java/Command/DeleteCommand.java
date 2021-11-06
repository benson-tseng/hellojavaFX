package Command;


public class DeleteCommand implements Command{

    private Combine combine;

    //Set Receiver
    public DeleteCommand (Combine combine){
        this.combine = combine;
    }

    //Call Receiver to do
    public void execute(){
        combine.deleteCmd();
    }

}
