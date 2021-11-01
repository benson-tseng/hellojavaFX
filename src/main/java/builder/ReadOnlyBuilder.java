package builder;

import Command.CommandInvoker;
import Command.Combine;
import composite.CMenu;
import composite.CMenuItem;

public class ReadOnlyBuilder extends MenuBarBuilder{
    Combine combine;
    CommandInvoker commandInvoker;

    public ReadOnlyBuilder(Combine combine,CommandInvoker commandInvoker){
        this.combine = combine;
        this.commandInvoker = commandInvoker;
    }

    public void buildMenuBar(){
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose",combine,commandInvoker);
        CMenuItem saveFile = new CMenuItem("SaveFile","menuItem_xml",combine,commandInvoker);
        CMenuItem openFile = new CMenuItem("OpenFile","open_file",combine,commandInvoker);
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        menuBar.getMenus().add(cMenu1.getMenu());
    }
}
