package Command;

import java.util.Stack;

//Apply Singleton Pattern
public class CommandInvoker {
    private static CommandInvoker commandInvoker;

    //Save command in stack;
    private Stack<Command> usedStack = new Stack<Command>();
    private Stack<Command> verStack = new Stack<Command>();
    private CommandInvoker(){
    }

    public void execute(Command cmd) {
        cmd.execute();
        if (cmd.getType() == "edit"){
            usedStack.push(cmd);
        } else if (cmd.getType() == "ver"){
            verStack.push(cmd);
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
