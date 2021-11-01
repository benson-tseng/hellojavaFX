package Command;

public class CopyCommand implements Command{

    private Combine combine;

    //Let CopyCommand's TextArea & Clipboard & ClipboardConten & curPosi equals to Controller
    public CopyCommand(Combine combine){
        this.combine = combine;
    }

    //Put the selectedText on clipboard.
    @Override
    public void execute() {
        combine.copyCmd();
    }

    //this.isReversible is return false, so no undo;
//    @Override
//    public void undo() {
//        //Can not undo;
//    }
//    //We set Copy Command is not reversible.
//    @Override
//    public boolean isReversible() {
//        return false;
//    }

}
