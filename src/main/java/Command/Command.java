package Command;

public interface Command {
    
    void execute();

    void undo();

    boolean isReversible();
}
