package State;

public interface State {
    // Same method on each State, but the content in method is different.
    void doAction(Context context);
}
