package composite;

import Command.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class CMenuItem implements Option{
    private MenuItem menuItem;
    private FileEdit fileEdit;
    private TextEdit textEdit;
    private Version version;
    private FontStyle fontStyle;
    private CommandInvoker commandInvoker;

    public CMenuItem(String text, String Id,FileEdit fileEdit,TextEdit textEdit,Version version,FontStyle fontStyle,CommandInvoker commandInvoker){
        this.menuItem = new MenuItem(text);
        this.fileEdit = fileEdit;
        this.textEdit = textEdit;
        this.version = version;
        this.fontStyle = fontStyle;
        this.commandInvoker = commandInvoker;
        menuItem.setId(Id);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                switch (Id){
                    case "save_file":
                        SaveCommand save = new SaveCommand(fileEdit);
                        commandInvoker.execute(save);
                        break;

                    case "open_file":
                        OpenCommand open = new OpenCommand(fileEdit);
                        commandInvoker.execute(open);
                        break;

                    case "Copy":
                        CopyCommand copy = new CopyCommand(textEdit);
                        commandInvoker.execute(copy);
                        break;

                    case "Paste":
                        PasteCommand paste = new PasteCommand(textEdit);
                        commandInvoker.execute(paste);
                        break;

                    case "SaveVersion":
                        SaveVersion saveVersion = new SaveVersion(version);
                        commandInvoker.execute(saveVersion);
                        break;

                    case "Previous":
                        PreviousCommand previous = new PreviousCommand(version);
                        commandInvoker.execute(previous);
                        break;

                    case "Next":
                        NextCommand next = new NextCommand(version);
                        commandInvoker.execute(next);
                        break;

                    case "cleanStyle":
                        CleanCommand clean = new CleanCommand(fontStyle);
                        commandInvoker.execute(clean);
                        break;

                    case "setBold":
                        BoldCommand bold = new BoldCommand(fontStyle);
                        commandInvoker.execute(bold);
                        break;

                    case "setBlue":
                        BlueCommand blue = new BlueCommand(fontStyle);
                        commandInvoker.execute(blue);
                        break;
                }

            }
        });
    }
    public MenuItem getMenuItem(){
        return menuItem;
    }

    public void click(){
        System.out.println("click Option");
    }
}
