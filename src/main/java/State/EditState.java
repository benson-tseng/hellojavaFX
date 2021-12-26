package State;

import javafx.scene.control.TextArea;

public class EditState implements State{
    private Context context;

    public EditState (Context context){
        this.context = context;
    }

    //If Idle time > 0 can edit, else context will change state to read
    public void toEdit(TextArea textArea,int t){
        if (t > 0){
            textArea.setEditable(true);
        } else {
            this.context.setState(new ReadState(this.context));
        }
    }

}
