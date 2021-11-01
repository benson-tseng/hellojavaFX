package Command;

import java.util.Stack;

//Apply Singleton Pattern
public class CommandInvoker {
    private static CommandInvoker commandInvoker;
    //Save command in stack;
    private Stack<Command> usedStack = new Stack<Command>();;

    private CommandInvoker(){
    }

    public void execute(Command cmd) {
        cmd.execute();
        usedStack.push(cmd);
    }

//    public void undo(){
//
//        if(!UndoStack.isEmpty()){
//            Command cmd = UndoStack.pop();//Set the cmd from the last one of UndoStack
//            RedoStack.push(cmd);
//            cmd.undo();
//        }
//        System.out.println(UndoStack);
//    }
//
//    public void redo(){
//
//        if(!RedoStack.isEmpty()){
//            Command cmd = RedoStack.pop();//Set the cmd from the last one of RedoStack
//            UndoStack.push(cmd);
//            cmd.execute();
//        }
//        System.out.println(UndoStack);
//    }

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
