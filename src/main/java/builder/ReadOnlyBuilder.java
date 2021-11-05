package builder;

import Command.CommandInvoker;
import Command.Combine;
import State.Context;
import composite.CMenu;
import composite.CMenuItem;

public class ReadOnlyBuilder extends MenuBarBuilder{
    private Combine combine;
    private CommandInvoker commandInvoker;
    private Context context;
    public ReadOnlyBuilder(Combine combine,CommandInvoker commandInvoker,Context context){
        this.combine = combine;
        this.commandInvoker = commandInvoker;
        this.context = context;
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
