package Command;

public class NextCommand implements Command{
    private Combine combine;

    public NextCommand(Combine combine){
        this.combine = combine;
    }

    @Override
    public void execute() {
        combine.next();
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
