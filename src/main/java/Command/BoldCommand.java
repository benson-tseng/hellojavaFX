package Command;

public class BoldCommand implements Command{
    private FontStyle fontStyle;

    //Set Receiver
    public BoldCommand (FontStyle fontStyle){
        this.fontStyle = fontStyle;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        fontStyle.setBold();
    }

    @Override
    public String getType() {
        return "edit";
    }

}
