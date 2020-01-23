package character;

import dnd.Die;

public class Player extends Character{

    public Player(String name, int armorClass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String hitDie) {
        super(name, armorClass, strength, dexterity, constitution, intelligence, wisdom, charisma);
        setHitPoints(Die.rollDie(hitDie)+constitution);
    }

    public void shortsword(Character other) {
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 2 + getStrength();

        //Is shortsword successful?
        if(attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d6")+getStrength();
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " slashes (shortsword) " + other.getName() + " for " + damageRoll + " damage");
        }
        else { //bite misses
            System.out.println(getName() + " attempts to slash (shortsword) " + other.getName() + " but misses.");
        }
    }

    @Override
    public void attack(Character other) {
        shortsword(other);
    }
}
