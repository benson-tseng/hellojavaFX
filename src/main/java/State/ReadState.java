package State;

public class ReadState implements State{

    public void doAction(Context context) {
        context.setState(this);
    }

    public boolean canUse() {
        return false;
    }
}
