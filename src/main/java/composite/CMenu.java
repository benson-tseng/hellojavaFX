package composite;

import javafx.scene.control.Menu;

import java.util.ArrayList;
import java.util.List;

public class CMenu implements Option{
    private Menu menu;
    private final List<CMenuItem> menuItems = new ArrayList<>();

    public CMenu(String text,String Id){
        this.menu = new Menu(text);
        menu.setId(Id);
    }

    public void add(CMenuItem cMenuItem){
        menuItems.add(cMenuItem);
    }

    public Menu getMenu(){
        return this.menu;
    }

    public void setMenuItem(){
        for(CMenuItem cMenuItem: menuItems){
            this.menu.getItems().add(cMenuItem.getMenuItem());
        }
    }
}
