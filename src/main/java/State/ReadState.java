package State;

import javafx.scene.control.TextArea;

public class ReadState implements State{
    private Context context;

    public ReadState (Context context){
        this.context = context;
    }

    //If Idle time < 1  textarea will lock and can not edit, else context will change state to edit
    public void toEdit(TextArea textArea,int t){
        if (t < 1){
            textArea.setEditable(false);
        } else {
            this.context.setState(new EditState(this.context));
        }
    }
}
