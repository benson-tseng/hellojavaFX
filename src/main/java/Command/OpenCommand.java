package Command;

public class OpenCommand implements Command{

    private Combine combine;

    public OpenCommand (Combine combine){
        this.combine = combine;
    }

    @Override
    public void execute() {
        combine.openCmd();
    }

//    @Override
//    public void undo() {
//
//    }
//
//    @Override
//    public boolean isReversible() {
//        return false;
//    }
}



