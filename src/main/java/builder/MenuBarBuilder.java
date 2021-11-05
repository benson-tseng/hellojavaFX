package builder;

import javafx.scene.control.MenuBar;

public abstract class MenuBarBuilder {
    protected MenuBar menuBar;

    public MenuBar getMenuBar(){
        return menuBar;}
    public void createNewMenuBar(){menuBar = new MenuBar();}

    public abstract void buildMenuBar();
}
