package Facade;

import State.Context;
import State.EditState;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import strategy.DocMeth;
import strategy.Meth;

import java.util.Timer;

public class OViewFacade {

    private TextArea textArea;
    private TextField searchKeyWord, inputEmail;
    private Text useMeth,resultNum,totalTextNum;
    private Meth meth;
    private Scene scene;
    private ComboBox chooseWord;
    private Label sendMailMsg;
    private Context context;
    private Timer timer;

    public OViewFacade (TextArea textArea, TextField searchKeyWord, TextField inputEmail, Text useMeth, Text resultNum,Text totalTextNum, Meth meth, Scene scene, ComboBox chooseWord,Label sendMailMsg,Context context,Timer timer){
        this.textArea = textArea;
        this.searchKeyWord = searchKeyWord;
        this.inputEmail = inputEmail;
        this.useMeth = useMeth;
        this.resultNum = resultNum;
        this.totalTextNum = totalTextNum;
        this.meth = meth;
        this.scene = scene;
        this.chooseWord = chooseWord;
        this.sendMailMsg = sendMailMsg;
        this.context = context;
        this.timer = timer;
    }

    //Back to the beginning
    public void init (){
        timer = new Timer();
        context.setState(new EditState(context));
        context.toEdit(textArea,90);
        textArea.setEditable(true);
        textArea.setText("");
        textArea.setStyle("");
        searchKeyWord.setText("");
        inputEmail.setText("");
        meth = new DocMeth();
        meth.editMeth(scene,textArea);
        useMeth.setText("Doc Edit Mode");
        resultNum.setText("0 Record");
        chooseWord.getItems().clear();
        sendMailMsg.setText("");
        totalTextNum.setText("Total 0 Word");

    }
}
