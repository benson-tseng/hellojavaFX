package com.example.hellojavafx;

import com.example.hellojavafx.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
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

    // proxy pattern
    public void login() throws IOException, InterruptedException {
        errmsg.setText("");

        // check if account & password have 4 to 8 digit
        if (acc.getText().length() < 4 || acc.getText().length() > 8) {
            errmsg.setVisible(true);
            errmsg.setText("account must have 4 to 8 digit");
        }
        if (pass.getText().length() < 4 || pass.getText().length() > 8) {
            if (errmsg.getText().equals("")) {
                errmsg.setVisible(true);
                errmsg.setText("password must have 4 to 8 digit");
            } else {
                errmsg.setText("account, password must have 4 to 8 digit");
            }
        }

        // if there's no error, then go to proxy pattern check whether the info is right
        if (errmsg.getText().equals("")) {
            proxy.Scene pScene = new ProxyScene(acc.getText(), pass.getText());

            // if realScene return true then construct the page, else pop up error msg
            if (pScene.navigate()) {
                errmsg.setText("login success!");
                errmsg.setStyle("-fx-text-fill: green");
                errmsg.setVisible(true);
                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                scene = new javafx.scene.Scene(fxmlLoader.load());
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
                HelloController controller = fxmlLoader.getController();
                controller.setScene(scene);
                controller.setStage(stage);
                controller.totalText();
            } else {
                errmsg.setVisible(true);
                errmsg.setText("wrong acc or pass");
            }

        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
