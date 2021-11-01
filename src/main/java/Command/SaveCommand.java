package Command;

public class SaveCommand implements Command{

    private Combine combine;

    public SaveCommand (Combine combine) {
        this.combine = combine;
    }

    // save file method
    @Override
    public void execute() {
        combine.saveCmd();
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
