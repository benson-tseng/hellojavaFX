package composite;

import Command.*;
import com.example.hellojavafx.Combine;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CMenuItem implements Option{
    private MenuItem menuItem;
    Combine combine;

    public CMenuItem(String text, String Id,Combine combine){
        this.menuItem = new MenuItem(text);
        this.combine = combine;
        menuItem.setId(Id);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                switch (Id){
                    case "fileClose":
                        combine.closeCmd();
                        break;

                    case "save_File":
                        combine.saveCmd();
                        break;

                    case "open_file":
                        combine.openCmd();
                        break;

                    case "Delete":
                        combine.deleteCmd();
                        break;

                    case "Copy":
                        combine.copyCmd();
                        break;

                    case "Paste":
                        combine.pasteCmd();
                        break;

                    case "undo":
                        combine.undo();
                        break;

                    case "redo":
                        combine.redo();
                        break;

                    case "SaveVersion":
                        combine.saveVersion();
                        break;

                    case "Previous":
                        combine.previous();
                        break;

                    case "Next":
                        combine.next();
                        break;

                }

            }
        });
    }
    public MenuItem getMenuItem(){
        return menuItem;
    }
}
