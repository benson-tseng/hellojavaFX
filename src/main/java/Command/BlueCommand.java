package Command;

public class BlueCommand implements Command{
    private Combine combine;

    public BlueCommand (Combine combine){
        this.combine = combine;
    }

    @Override
    public void execute() {
        combine.setBlue();
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
