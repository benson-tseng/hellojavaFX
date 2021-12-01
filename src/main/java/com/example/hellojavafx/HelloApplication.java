package com.example.hellojavafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws IOException {

        // singleton pattern
        if(fxmlLoader == null){
            synchronized (FXMLLoader.class){
                if(fxmlLoader == null){
                    fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                }
            }
        }

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("index.fxml"));

        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Index controller = fxmlLoader.getController();
        controller.setScene(scene);
        controller.setStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}