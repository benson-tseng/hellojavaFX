package State;

import javafx.scene.control.TextArea;

public class ReadState implements State{
    private Context context;

    public ReadState (Context context){
        this.context = context;
    }

    public void toEdit(TextArea textArea,int t){
        if (t < 1){
            textArea.setEditable(false);
        } else {
            this.context.setState(new EditState(this.context));
        }
    }
}
