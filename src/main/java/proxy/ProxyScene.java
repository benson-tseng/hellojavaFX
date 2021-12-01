package proxy;

import javafx.stage.Stage;

import java.io.IOException;

public class ProxyScene extends Scene{
    private Scene scene;
    private String acc,pass;

    public ProxyScene(String s1,String s2){
        acc = s1;
        pass = s2;
    }

    public void navigate(Stage stage, javafx.scene.Scene scene) throws IOException {
        if(acc.equals("user") && pass.equals("user123")){
            this.scene = new RealScene();
            this.scene.navigate(stage,scene);
        }
    }
}
