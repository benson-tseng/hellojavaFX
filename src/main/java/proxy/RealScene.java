package proxy;

import com.example.hellojavafx.HelloApplication;
import com.example.hellojavafx.HelloController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class RealScene extends Scene{

    protected FXMLLoader fxmlLoader;

    public void navigate(Stage stage, javafx.scene.Scene scene) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene = new javafx.scene.Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        HelloController controller = fxmlLoader.getController();
        controller.setScene(scene);
        controller.setStage(stage);
        controller.totalText();
    }
}
