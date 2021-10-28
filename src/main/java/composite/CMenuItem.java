package composite;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CMenuItem implements Option{
    private MenuItem menuItem;

    public CMenuItem(String text, String Id){
        this.menuItem=new MenuItem(text);
        menuItem.setId(Id);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("123");
            }
        });
    }
    public MenuItem getMenuItem(){
        return menuItem;
    }
}
