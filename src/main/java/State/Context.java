package State;

import javafx.animation.AnimationTimer;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Context {

    private State state;

    //Default state
    public Context() {
        state = new EditState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    //this will call which the state context is to do toEdit
    public void toEdit(TextArea textArea,int t){
        state.toEdit(textArea,t);
    }

}

