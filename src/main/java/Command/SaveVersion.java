package Command;

public class SaveVersion implements Command {

    private Combine combine;

    public SaveVersion (Combine combine){
        this.combine = combine;
    }

    @Override
    public void execute() {
        combine.saveVersion();
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
