package character;

import dnd.Die;

public class Monster extends Character {

    public Monster(String name, int armorClass, int strength,
                   int dexterity, int constitution, int intelligence,
                   int wisdom, int charisma, String hitDie) {
        super(name, armorClass, strength, dexterity,constitution,
                intelligence,wisdom,charisma);
        super.setHitPoints(Die.rollDie(hitDie));
    }
}
