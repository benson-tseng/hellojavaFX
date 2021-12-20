package State;

import javafx.animation.AnimationTimer;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Context {

    private State state;

    public Context() {
        state = new EditState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    public void toEdit(TextArea textArea,int t){
        state.toEdit(textArea,t);
    }

}

//    public void Idletimer(){
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                if (t > 0) {
//                    System.out.println(t);
//                    t--;
//                } else {
//                    cState = readState;
//
//                }
//            }
//        };
//        timer.scheduleAtFixedRate(timerTask,0,1000);
//    }
