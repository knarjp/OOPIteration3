package Model.Command.EntityCommand.NonSettableCommand.ToggleableCommand;

import Controller.Visitor.SavingVisitor;
import Model.Entity.Entity;

public class ToggleSpeedCommand extends ToggleableCommand {

    int amount;

    public ToggleSpeedCommand(int amount) {
        super();
        this.amount = amount;
    }

    public ToggleSpeedCommand(int amount, boolean hasFired) {
        super(hasFired);
        this.amount = amount;
    }

    public void execute(Entity entity) {
        if(!hasFired()){
            entity.increaseSpeed(amount);
            toggleHasFired();
        } else{
            entity.decreaseSpeed(amount);
            toggleHasFired();
        }
    }

    @Override
    public void accept(SavingVisitor visitor) {
        visitor.visitSpeedCommand(this);
    }
}