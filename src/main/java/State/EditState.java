package State;

import Command.Combine;
import builder.Director;
import builder.EditBuilder;
import builder.MenuBarBuilder;

public class EditState implements State{
    private Context context;

    public void doAction(Context context) {
        context.setState(this);
    }

}
