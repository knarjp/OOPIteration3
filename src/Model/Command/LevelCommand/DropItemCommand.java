package Model.Command.LevelCommand;

import Model.Entity.Entity;
import Model.Item.TakeableItem.TakeableItem;
import Model.Level.GameModel;
import Model.Level.Level;
import Model.Level.LevelMessenger;
import javafx.geometry.Point3D;

public class DropItemCommand extends LevelCommand {

    private Entity entity;
    private TakeableItem item;

    public DropItemCommand(LevelMessenger levelMessenger) {
        super(levelMessenger);
    }

    @Override
    public void receiveGameModel(GameModel gameModel) {
        Level level = gameModel.getCurrentLevel();

        Point3D entityPoint = level.getEntityPoint(entity);

        if(entityPoint != null) {
            entity.removeItemFromInventory(this.item);
            //TODO: Make logic to not drop at same point as entity.
            level.addItemnTo(entityPoint, item);
        }
    }

    @Override
    public void execute(Entity entity) {
        this.entity = entity;

        sendCommandToGameModel(this);
    }

    public void setItem(TakeableItem item) {
        this.item = item;
    }
}
