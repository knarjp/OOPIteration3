package Controller.Factories.EntityFactories;

import Controller.Factories.SkillsFactory;
import Model.Entity.Entity;
import Model.Item.TakeableItem.TakeableItem;

import View.LevelView.EntityView.MonsterView;
import javafx.geometry.Point3D;


public class MonsterFactory extends EntityFactory {

    public MonsterFactory(SkillsFactory skillsFactory){
        super(skillsFactory);
    }

    @Override
    public Entity buildEntity() {
        return buildEntity(null);
    }

    public Entity buildEntity(TakeableItem... items) {
        Entity monster = new Entity();
        monster.setName("grok");

        if(items != null) {
            for (int i = 0; i < items.length; ++i) {
                monster.addItemToInventory(items[i]);
            }
        }

        monster.addWeaponSkills(getSkillsFactory().getTwoHandedSkill());

        return monster;
    }


    public void buildEntitySprite(Entity entity) {
        MonsterView monsterView = new MonsterView(entity, new Point3D(0,0,0));
    }

}
