package character;

import dnd.Die;

public abstract class Monster extends Character {

    private double cr = -1;

    public Monster(String name, int armorClass, int strength,
                   int dexterity, int constitution, int intelligence,
                   int wisdom, int charisma, String hitDie) {
        super(name, armorClass, strength, dexterity,constitution,
                intelligence,wisdom,charisma);
        super.setHitPoints(Die.rollDie(hitDie));
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }
}
