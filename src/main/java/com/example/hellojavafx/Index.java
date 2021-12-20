package com.example.hellojavafx;

import com.example.hellojavafx.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proxy.ProxyScene;

import java.io.IOException;

public class Index {
    private FXMLLoader fxmlLoader;
    @FXML
    private Scene scene;

    private Stage stage;

    @FXML
    private TextField acc;

    @FXML
    private PasswordField pass;

    @FXML
    private Label errmsg;

    public void login() throws IOException {
        errmsg.setText("");
        if(acc.getText().length()<4 || acc.getText().length()>8){
            errmsg.setVisible(true);
            errmsg.setText("account must have 4 to 8 digit");
        }
        if(pass.getText().length()<4 || pass.getText().length()>8){
            if(errmsg.getText().equals("")){
                errmsg.setVisible(true);
                errmsg.setText("password must have 4 to 8 digit");
            }else{
                errmsg.setText("account, password must have 4 to 8 digit");
            }
        }
        if(errmsg.getText().equals("")){
            proxy.Scene pScene = new ProxyScene(acc.getText(),pass.getText());
            pScene.navigate(stage,scene,errmsg);
        }
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
}
