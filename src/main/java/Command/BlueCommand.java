package Command;

public class BlueCommand implements Command{
    private FontStyle fontStyle;

    //Set Receiver
    public BlueCommand (FontStyle fontStyle){
        this.fontStyle = fontStyle;
    }

    //Call Receiver to do
    @Override
    public void execute() {
        fontStyle.setBlue();
    }

    @Override
    public String getType() {
        return "edit";
    }
}
