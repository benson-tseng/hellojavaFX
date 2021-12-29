package builder;

import Command.*;
import State.Context;
import composite.CMenu;
import composite.CMenuItem;

public class EditBuilder extends MenuBarBuilder{
    private CommandInvoker commandInvoker;
    private FileEdit fileEdit;
    private TextEdit textEdit;
    private Version version;
    private FontStyle fontStyle;

    public EditBuilder(FileEdit fileEdit,TextEdit textEdit,Version version,FontStyle fontStyle,CommandInvoker commandInvoker,Context context){
         this.fileEdit = fileEdit;
         this.textEdit = textEdit;
         this.version = version;
         this.fontStyle = fontStyle;
         this.commandInvoker = commandInvoker;
    }

    public void buildMenuBar() {
        Class[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem saveFile = new CMenuItem("SaveFile","save_file",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem openFile = new CMenuItem("OpenFile","open_file",fileEdit,textEdit,version,fontStyle,commandInvoker);
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        CMenu cMenu2 = new CMenu("Edit Method","EditMethod");
        CMenuItem docEdit = new CMenuItem("Doc Edit","docEdit",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem codeEdit = new CMenuItem("Code Edit","codeEdit",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem htmlEdit = new CMenuItem("HTML Edit","htmlEdit",fileEdit,textEdit,version,fontStyle,commandInvoker);
        cMenu2.add(docEdit);
        cMenu2.add(codeEdit);
        cMenu2.add(htmlEdit);
        cMenu2.setMenuItem();
        CMenu cMenu3 = new CMenu("TextEdit","TextEdit");
        CMenuItem copy = new CMenuItem("Copy","Copy",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem paste = new CMenuItem("Paste","Paste",fileEdit,textEdit,version,fontStyle,commandInvoker);
        cMenu3.add(copy);
        cMenu3.add(paste);
        cMenu3.setMenuItem();
        CMenu cMenu4 = new CMenu("Version","Version");
        CMenuItem saveVersion = new CMenuItem("Save Version","SaveVersion",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem previous = new CMenuItem("Previous","Previous",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem next = new CMenuItem("Next","Next",fileEdit,textEdit,version,fontStyle,commandInvoker);
        cMenu4.add(saveVersion);
        cMenu4.add(previous);
        cMenu4.add(next);
        cMenu4.setMenuItem();
        CMenu cMenu5 = new CMenu("Set Style","setStyle");
        CMenuItem cleanStyle = new CMenuItem("Clean Style","cleanStyle",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem setBold = new CMenuItem("Set Bold","setBold",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem setBlue = new CMenuItem("Set Blue","setBlue",fileEdit,textEdit,version,fontStyle,commandInvoker);
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
