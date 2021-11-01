package Command;

public class PreviousCommand implements Command{

    private Combine combine;

    public PreviousCommand (Combine combine){
        this.combine = combine;

    }

    @Override
    public void execute() {
        combine.previous();
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
