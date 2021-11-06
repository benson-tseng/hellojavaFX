package State;

public class EditState implements State{
    private Context context;

    public void doAction(Context context) {
        context.setState(this);
    }

}
