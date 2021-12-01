package proxy;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

abstract public class Scene {

    abstract public void navigate(Stage stage, javafx.scene.Scene scene) throws IOException;
}
