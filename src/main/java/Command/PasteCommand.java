package Command;

public class PasteCommand implements Command{

    private Combine combine;

    //Let PasteCommand's TextArea & Clipboard & curPosi equals to Controller
    public PasteCommand(Combine combine){
        this.combine = combine;
    }

    //Insert the clipboard's string on the textArea.
    @Override
    public void execute() {
        combine.pasteCmd();
    }

//    //Back to the textArea's text before Paste
//    @Override
//    public void undo() {
//        combine.pasteUndo();
//    }
//
//    //We set Paste Command is reversible.
//    @Override
//    public boolean isReversible() {
//        return true;
//    }
}
