package builder;

import composite.CMenu;
import composite.CMenuItem;
import com.example.hellojavafx.HelloController;

public class EditBuilder extends MenuBarBuilder{
    HelloController h = new HelloController();
    public void buildMenuBar() {
        Class[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose");
        CMenuItem saveFile = new CMenuItem("SaveFile","menuItem_xml");
        CMenuItem openFile = new CMenuItem("OpenFile","open_file");
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        CMenu cMenu2 = new CMenu("Edit Method","EditMethod");
        CMenuItem docEdit = new CMenuItem("Doc Edit","docEdit");
        CMenuItem codeEdit = new CMenuItem("Code Edit","codeEdit");
        CMenuItem htmlEdit = new CMenuItem("HTML Edit","htmlEdit");
        cMenu2.add(docEdit);
        cMenu2.add(codeEdit);
        cMenu2.add(htmlEdit);
        cMenu2.setMenuItem();
        CMenu cMenu3 = new CMenu("TextEdit","TextEdit");
        CMenuItem delete = new CMenuItem("Delete","Delete");
        CMenuItem copy = new CMenuItem("Copy","Copy");
        CMenuItem paste = new CMenuItem("Paste","Paste");
        CMenuItem undo = new CMenuItem("Undo","undo");
        CMenuItem redo = new CMenuItem("Redo","redo");
        cMenu3.add(delete);
        cMenu3.add(copy);
        cMenu3.add(paste);
        cMenu3.add(undo);
        cMenu3.add(redo);
        cMenu3.setMenuItem();
        CMenu cMenu4 = new CMenu("Version","Version");
        CMenuItem saveVersion = new CMenuItem("Save Version","SaveVersion");
        CMenuItem previous = new CMenuItem("Previous","Previous");
        CMenuItem next = new CMenuItem("Next","Next");
        cMenu4.add(saveVersion);
        cMenu4.add(previous);
        cMenu4.add(next);
        cMenu4.setMenuItem();
        menuBar.getMenus().add(cMenu1.getMenu());
        menuBar.getMenus().add(cMenu2.getMenu());
        menuBar.getMenus().add(cMenu3.getMenu());
        menuBar.getMenus().add(cMenu4.getMenu());
    }
}
