package Model.MenuModel;

import Controller.GameLoop;
import Model.Entity.Entity;

public class DialogMenu extends MenuState {

    private boolean wantToTalk;
    private Entity player;
    private Entity npc;

    public DialogMenu(MenuModel menuModel, GameLoop gameLoop, boolean wantToTalk, Entity player, Entity npc) {
        super(menuModel, gameLoop);
        this.wantToTalk = wantToTalk;
        this.player = player;
        this.npc = npc;
    }

    @Override
    public void correctParameters() {
        if(selectedUpDown != 0) selectedUpDown = 0;
        if(wantToTalk){
            if(selectedLeftRight < 0) selectedLeftRight = 0;
            if(selectedLeftRight > 1) selectedLeftRight = 0;
        }else{
            if(selectedLeftRight!=0) selectedLeftRight = 0;
        }
    }

    @Override
    public void select() {
        if(selectedLeftRight == 1) gameLoop.openBarterWindow(player, player, npc);
    }
}
