package builder;

import Command.*;
import State.Context;
import composite.CMenu;
import composite.CMenuItem;

public class ReadOnlyBuilder extends MenuBarBuilder{
    private FileEdit fileEdit;
    private TextEdit textEdit;
    private Version version;
    private FontStyle fontStyle;
    private CommandInvoker commandInvoker;
    public ReadOnlyBuilder(FileEdit fileEdit,TextEdit textEdit,Version version,FontStyle fontStyle,CommandInvoker commandInvoker,Context context){
        this.fileEdit = fileEdit;
        this.textEdit = textEdit;
        this.version = version;
        this.fontStyle = fontStyle;
        this.commandInvoker = commandInvoker;
    }

    public void buildMenuBar(){
        CMenu cMenu1 = new CMenu("File","File");
        CMenuItem close = new CMenuItem("Close","fileClose",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem saveFile = new CMenuItem("SaveFile","menuItem_xml",fileEdit,textEdit,version,fontStyle,commandInvoker);
        CMenuItem openFile = new CMenuItem("OpenFile","open_file",fileEdit,textEdit,version,fontStyle,commandInvoker);
        cMenu1.add(close);
        cMenu1.add(saveFile);
        cMenu1.add(openFile);
        cMenu1.setMenuItem();
        menuBar.getMenus().add(cMenu1.getMenu());

    }
}
