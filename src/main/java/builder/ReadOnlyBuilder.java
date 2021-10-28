package builder;

import composite.CMenu;
import composite.CMenuItem;

public class ReadOnlyBuilder extends MenuBarBuilder{
    public void buildMenuBar(){
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose");
        CMenuItem saveFile = new CMenuItem("SaveFile","menuItem_xml");
        CMenuItem openFile = new CMenuItem("OpenFile","open_file");
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        menuBar.getMenus().add(cMenu1.getMenu());
    }
}
