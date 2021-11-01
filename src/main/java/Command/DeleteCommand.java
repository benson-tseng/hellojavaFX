package Command;


public class DeleteCommand implements Command{

    private Combine combine;

    ////Let DeleteCommand's TextArea & curPosi equals to Controller
    public DeleteCommand (Combine combine){
        this.combine = combine;
    }

    public void execute(){
        combine.deleteCmd();
    }

//    public void undo(){
//        combine.delUndo();
//    }
//
//    public boolean isReversible(){
//
//        return true;
//
//    }

}
