package Facade;

import State.Context;
import State.EditState;
import com.example.hellojavafx.HelloController;
import strategy.DocMeth;
import strategy.Meth;

import java.util.Timer;

public class OViewFacade {

    private HelloController helloController;
    private Meth meth;
    private Context context;
    private Timer timer;

    public OViewFacade (HelloController helloController,Meth meth,Context context){
        this.helloController = helloController;
        this.meth = meth;
        this.context = context;
        this.timer = helloController.getTimer();
    }

    //Back to the beginning
    public void init (){
        timer = new Timer();
        context.setState(new EditState(context));
        context.toEdit(helloController.getTextArea(), 90);
        meth = new DocMeth();
        meth.editMeth(helloController.getScene(), helloController.getTextArea());
        helloController.init();
    }
}
