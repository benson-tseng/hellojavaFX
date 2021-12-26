package proxy;

public class ProxyScene extends Scene{
    private Scene scene;
    private String acc,pass;

    public ProxyScene(String s1,String s2){
        acc = s1;
        pass = s2;
    }

    public boolean navigate() {
        if(acc.equals("user") && pass.equals("user123")){
            this.scene = new RealScene();
            return this.scene.navigate();
        }
        return false;
    }
}
