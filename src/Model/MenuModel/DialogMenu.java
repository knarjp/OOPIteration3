package Model.MenuModel;

import Controller.Factories.SkillsFactory;
import Controller.GameLoop;
import Model.Command.EntityCommand.SettableCommand.BarterCommand;
import Model.Entity.Entity;

public class DialogMenu extends MenuState {

    private boolean wantToTalk;
    private Entity player;
    private Entity npc;
    private SkillsFactory skillsFactory;

    public DialogMenu(MenuModel menuModel, GameLoop gameLoop, boolean wantToTalk, Entity player, Entity npc, SkillsFactory skillsFactory) {
        super(menuModel, gameLoop);
        this.wantToTalk = wantToTalk;
        this.player = player;
        this.npc = npc;
        this.skillsFactory = skillsFactory;
    }

    @Override
    public void correctParameters() {
        if(selectedUpDown != 0) selectedUpDown = 0;
        if(wantToTalk){
            if(selectedLeftRight < 0) selectedLeftRight = 1;
            if(selectedLeftRight > 1) selectedLeftRight = 0;
        }else{
            if(selectedLeftRight!=0) selectedLeftRight = 0;
        }
    }

    @Override
    public void select() {
        if(selectedLeftRight == 0) gameLoop.closeMenu();
        // TODO: actually send barter skill level
        if(selectedLeftRight == 1) {
            skillsFactory.getBargainSkill().fire(player);
        }
    }

    public boolean getWantToTalk(){
        return wantToTalk;
    }
}
