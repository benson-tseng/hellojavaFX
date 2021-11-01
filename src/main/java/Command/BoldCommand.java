package Command;

public class BoldCommand implements Command{
    private Combine combine;

    public BoldCommand (Combine combine){
        this.combine = combine;
    }

    @Override
    public void execute() {
        combine.setBold();
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
