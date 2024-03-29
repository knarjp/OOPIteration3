package Model.MenuModel;

import Controller.GameLoop;

public abstract class MenuState {

    protected int selectedLeftRight = 0;
    protected int selectedUpDown = 0;
    protected MenuModel menuModel;
    protected GameLoop gameLoop;

    public MenuState(MenuModel menuModel, GameLoop gameLoop) {
        this.menuModel = menuModel;
        this.gameLoop = gameLoop;
    }


    public void scrollLeft(){
        selectedLeftRight--;
        correctParameters();
    }

    public void scrollRight(){
        selectedLeftRight++;
        correctParameters();
    }

    public void scrollUp(){
        selectedUpDown--;
        correctParameters();
    }

    public void scrollDown(){
        selectedUpDown++;
        correctParameters();
    }

    public abstract void correctParameters();

    public abstract void select();

    public int getHorizontal() {
        return selectedLeftRight;
    }

    public int getVertical() {
        return selectedUpDown;
    }
}
