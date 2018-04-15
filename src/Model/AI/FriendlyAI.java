package Model.AI;

import Model.Entity.Entity;
import Model.Level.Obstacle;
import Model.Level.Terrain;
import javafx.geometry.Point3D;
import java.util.Map;

public class FriendlyAI extends AIState{

    public FriendlyAI(Entity ent) {
        super(ent);
    }

    @Override
    public void nextMove(Entity player, Map<Point3D, Terrain> terrainMap, Map<Point3D, Entity> entityMap, Map<Point3D, Obstacle> obstacleMap) {

    }
}
