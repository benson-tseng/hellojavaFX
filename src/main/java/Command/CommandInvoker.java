package Command;

import java.util.Stack;

public class CommandInvoker {

    //Save undo & redo command in stack;
    private Stack<Command> UndoStack;
    private Stack<Command> RedoStack;

    public CommandInvoker(){
        UndoStack = new Stack<Command>();
        RedoStack = new Stack<Command>();
    }

    public void execute(Command cmd) {
        cmd.execute();
        System.out.println(UndoStack);
        if (cmd.isReversible()) {
            UndoStack.push(cmd);
        }
    }

    public void undo(){

        if(!UndoStack.isEmpty()){
            Command cmd = UndoStack.pop();//Set the cmd from the last one of UndoStack
            RedoStack.push(cmd);
            cmd.undo();
        }
    }

    public void redo(){

        if(!RedoStack.isEmpty()){
            Command cmd = RedoStack.pop();//Set the cmd from the last one of RedoStack
            UndoStack.push(cmd);
            cmd.execute();
        }
    }

}
