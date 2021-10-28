package builder;

import javafx.scene.control.MenuBar;

public class Director {
    private MenuBarBuilder menuBarBuilder;

    public void setMenuBarBuilder(MenuBarBuilder mb){this.menuBarBuilder = mb;};

    public MenuBar getMenuBar(){return menuBarBuilder.getMenuBar();}

    public void constructMenuBar(){
        menuBarBuilder.createNewMenuBar();
        menuBarBuilder.buildMenuBar();
    }
}
