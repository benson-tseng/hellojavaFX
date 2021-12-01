package com.example.hellojavafx;

import com.example.hellojavafx.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    public void login() throws IOException {
        proxy.Scene pScene = new ProxyScene(acc.getText(),pass.getText());
        pScene.navigate(stage,scene);
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
}
