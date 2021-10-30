package com.example.hellojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
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

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        HelloController controller = fxmlLoader.getController();
        controller.setScene(scene);
        controller.setStage(stage);
        controller.totalText();
    }

    public static void main(String[] args) {
        launch();
    }

}