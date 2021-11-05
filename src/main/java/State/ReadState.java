package State;

public class ReadState implements State{
    private Context context;

    public void doAction(Context context) {
        context.setState(this);
    }

}
