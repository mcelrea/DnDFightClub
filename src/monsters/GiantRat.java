package monsters;

import character.Monster;
import character.Character;
import dnd.Die;

public class GiantRat extends Monster {

    public GiantRat(String name) {
        super(name,
                12,
                -2,
                +2,
                +0,
                -4,
                +0,
                -3,
                "2d6");
    }

    public void bite(Character other) {
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 4;

        //Is bite successful?
        if(attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d4");
            damageRoll += 2;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " bites " + other.getName() + " for " + damageRoll + " damage");
        }
        else { //bite misses
            System.out.println(getName() + " attempts to bite " + other.getName() + " but misses.");
        }
    }
}
