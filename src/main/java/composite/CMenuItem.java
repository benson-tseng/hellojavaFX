package composite;

import Command.*;
import Command.Combine;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class CMenuItem implements Option{
    private MenuItem menuItem;
    private Combine combine;
    private CommandInvoker commandInvoker;

    public CMenuItem(String text, String Id,Combine combine,CommandInvoker commandInvoker){
        this.menuItem = new MenuItem(text);
        this.combine = combine;
        this.commandInvoker = commandInvoker;
        menuItem.setId(Id);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                switch (Id){
                    case "save_file":
                        SaveCommand save = new SaveCommand(combine);
                        commandInvoker.execute(save);
                        break;

                    case "open_file":
                        OpenCommand open = new OpenCommand(combine);
                        commandInvoker.execute(open);
                        break;

                    case "Delete":
                        DeleteCommand del = new DeleteCommand(combine);
                        commandInvoker.execute(del);
                        break;

                    case "Copy":
                        CopyCommand copy = new CopyCommand(combine);
                        commandInvoker.execute(copy);
                        break;

                    case "Paste":
                        PasteCommand paste = new PasteCommand(combine);
                        commandInvoker.execute(paste);
                        break;

                    case "SaveVersion":
                        SaveVersion saveVersion = new SaveVersion(combine);
                        commandInvoker.execute(saveVersion);
                        break;

                    case "Previous":
                        PreviousCommand previous = new PreviousCommand(combine);
                        commandInvoker.execute(previous);
                        break;

                    case "Next":
                        NextCommand next = new NextCommand(combine);
                        commandInvoker.execute(next);
                        break;

                    case "cleanStyle":
                        CleanCommand clean = new CleanCommand(combine);
                        commandInvoker.execute(clean);
                        break;

                    case "setBold":
                        BoldCommand bold = new BoldCommand(combine);
                        commandInvoker.execute(bold);
                        break;

                    case "setBlue":
                        BlueCommand blue = new BlueCommand(combine);
                        commandInvoker.execute(blue);
                        break;
                }

            }
        });
    }
    public MenuItem getMenuItem(){
        return menuItem;
    }
}


//                    case "undo":
//                        commandInvoker.undo();
//                        break;
//
//                    case "redo":
//                        commandInvoker.redo();
//                        break;