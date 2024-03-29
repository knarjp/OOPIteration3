package Model.Command.EntityCommand.SettableCommand;

import Controller.Visitor.Visitor;
import Model.Command.LevelCommand.LevelCommand;
import Model.Entity.Entity;
import Model.Level.Level;
import Model.Level.LevelMessenger;

public class DisarmTrapCommand extends LevelCommand implements SettableCommand {

    private Entity entity;

    int disarmStrength;

    public DisarmTrapCommand(LevelMessenger levelMessenger) {
        super(levelMessenger);
        this.disarmStrength = 5;
    }

    public void receiveLevel(Level level) {
        level.disarmTrapFromEntity(entity, disarmStrength);
    }

    public void execute(Entity entity) {
        this.entity = entity;
        sendCommandToLevel();
    }

    public void setAmount(int amount) {
        this.disarmStrength = amount;
    }

    public int getAmount() {
        return disarmStrength;
    }

    public Entity getEntity() {
        return entity;
    }

    public void accept(Visitor visitor) {
        visitor.visitDisarmTrapCommand(this);
    }
}
