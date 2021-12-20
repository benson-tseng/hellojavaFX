package Command;

public class CleanCommand implements Command {
    private FontStyle fontStyle;

    //Set Receiver
    public CleanCommand(FontStyle fontStyle){
        this.fontStyle = fontStyle;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        fontStyle.cleanStyle();
    }

    @Override
    public String getType() {
        return "edit";
    }
}
