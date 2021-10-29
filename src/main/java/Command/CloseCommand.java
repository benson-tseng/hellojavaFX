package Command;

public class CloseCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Close");
    }

    @Override
    public void undo() {

    }

    @Override
    public boolean isReversible() {
        return false;
    }
}
