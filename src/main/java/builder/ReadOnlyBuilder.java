package builder;

import Command.CommandInvoker;
import com.example.hellojavafx.Combine;
import com.example.hellojavafx.HelloController;
import composite.CMenu;
import composite.CMenuItem;
import javafx.scene.control.TextArea;

public class ReadOnlyBuilder extends MenuBarBuilder{
    Combine combine;

    public ReadOnlyBuilder(Combine combine){
        this.combine = combine;
    }

    public void buildMenuBar(){
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose",combine);
        CMenuItem saveFile = new CMenuItem("SaveFile","menuItem_xml",combine);
        CMenuItem openFile = new CMenuItem("OpenFile","open_file",combine);
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        menuBar.getMenus().add(cMenu1.getMenu());
    }
}
