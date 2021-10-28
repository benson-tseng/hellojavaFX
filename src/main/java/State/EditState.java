package State;

public class EditState implements State{

    public void doAction(Context context) {
        context.setState(this);
    }

    public boolean canUse() {
        return true;
    }
}
