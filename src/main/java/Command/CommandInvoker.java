package Command;

import java.util.Stack;

//Apply Singleton Pattern
public class CommandInvoker {
    private static CommandInvoker commandInvoker;
    //Save undo & redo command in stack;
    private Stack<Command> UndoStack;
    private Stack<Command> RedoStack;

    private CommandInvoker(){
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

    public static CommandInvoker getInstance(){
        if(commandInvoker == null){
            synchronized (CommandInvoker.class){
                if (commandInvoker == null){
                    commandInvoker = new CommandInvoker();
                }
            }
        }
        return commandInvoker;
    }

}
