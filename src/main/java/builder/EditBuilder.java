package builder;

import Command.*;
import Command.Combine;
import State.Context;
import composite.CMenu;
import composite.CMenuItem;

public class EditBuilder extends MenuBarBuilder{
    private CommandInvoker commandInvoker;
    private Combine combine;
    private Context context;
    public EditBuilder(Combine combine,CommandInvoker commandInvoker,Context context){
         this.combine = combine;
         this.commandInvoker = commandInvoker;
         this.context = context;
    }

    public void buildMenuBar() {
        Class[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose",combine,commandInvoker);
        CMenuItem saveFile = new CMenuItem("SaveFile","save_file",combine,commandInvoker);
        CMenuItem openFile = new CMenuItem("OpenFile","open_file",combine,commandInvoker);
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        CMenu cMenu2 = new CMenu("Edit Method","EditMethod");
        CMenuItem docEdit = new CMenuItem("Doc Edit","docEdit",combine,commandInvoker);
        CMenuItem codeEdit = new CMenuItem("Code Edit","codeEdit",combine,commandInvoker);
        CMenuItem htmlEdit = new CMenuItem("HTML Edit","htmlEdit",combine,commandInvoker);
        cMenu2.add(docEdit);
        cMenu2.add(codeEdit);
        cMenu2.add(htmlEdit);
        cMenu2.setMenuItem();
        CMenu cMenu3 = new CMenu("TextEdit","TextEdit");
        CMenuItem delete = new CMenuItem("Delete","Delete",combine,commandInvoker);
        CMenuItem copy = new CMenuItem("Copy","Copy",combine,commandInvoker);
        CMenuItem paste = new CMenuItem("Paste","Paste",combine,commandInvoker);
        cMenu3.add(delete);
        cMenu3.add(copy);
        cMenu3.add(paste);
        cMenu3.setMenuItem();
        CMenu cMenu4 = new CMenu("Version","Version");
        CMenuItem saveVersion = new CMenuItem("Save Version","SaveVersion",combine,commandInvoker);
        CMenuItem previous = new CMenuItem("Previous","Previous",combine,commandInvoker);
        CMenuItem next = new CMenuItem("Next","Next",combine,commandInvoker);
        cMenu4.add(saveVersion);
        cMenu4.add(previous);
        cMenu4.add(next);
        cMenu4.setMenuItem();
        CMenu cMenu5 = new CMenu("Set Style","setStyle");
        CMenuItem cleanStyle = new CMenuItem("Clean Style","cleanStyle",combine,commandInvoker);
        CMenuItem setBold = new CMenuItem("Set Bold","setBold",combine,commandInvoker);
        CMenuItem setBlue = new CMenuItem("Set Blue","setBlue",combine,commandInvoker);
        cMenu5.add(cleanStyle);
        cMenu5.add(setBold);
        cMenu5.add(setBlue);
        cMenu5.setMenuItem();
        menuBar.getMenus().add(cMenu1.getMenu());
        menuBar.getMenus().add(cMenu2.getMenu());
        menuBar.getMenus().add(cMenu3.getMenu());
        menuBar.getMenus().add(cMenu4.getMenu());
        menuBar.getMenus().add(cMenu5.getMenu());
    }
}

//    CMenuItem undo = new CMenuItem("Undo","undo",combine,commandInvoker);
//    CMenuItem redo = new CMenuItem("Redo","redo",combine,commandInvoker);
//    cMenu3.add(undo);
//    cMenu3.add(redo);