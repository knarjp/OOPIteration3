package ModelTests;

import Model.Command.LevelCommand.SendInfluenceEffectCommand;
import Model.Entity.Entity;
import Model.InfluenceEffect.InfluenceEffect;
import Model.Level.Level;
import Model.Level.LevelMessenger;
import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class SendInfluenceEffectCommandTests {

    private SendInfluenceEffectCommand sendInfluenceEffectCommand;
    private Entity entity;
    private Level level;
    private LevelMessenger levelMessenger;
    private InfluenceEffect influenceEffect;

    @Before
    public void init() {
        entity = new Entity();
        level = new Level(new ArrayList<>());
        level.addEntityTo(new Point3D(0,0,0), entity);
        levelMessenger = new LevelMessenger(null, level);
        sendInfluenceEffectCommand = new SendInfluenceEffectCommand(levelMessenger);
        influenceEffect = new InfluenceEffect();
    }

    @Test
    public void influenceEffectsAddsToLevelTest() {
        sendInfluenceEffectCommand.setInfluenceEffect(influenceEffect);
        sendInfluenceEffectCommand.execute(entity);
        sendInfluenceEffectCommand.sendCommandToLevel();

        Map<Point3D,InfluenceEffect> influencesMap = level.getInfluencesMap();
        assertTrue(influencesMap.containsValue(influenceEffect));
    }
}