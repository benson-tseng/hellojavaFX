package Command;

public class CleanCommand implements Command {
    private Combine combine;

    public CleanCommand(Combine combine){
        this.combine = combine;
    }

    @Override
    public void execute() {
        combine.cleanStyle();
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
