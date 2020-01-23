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
        super.setCr(0.125);
    }

    @Override
    public void attack(Character other) {
        bite(other);
    }


    public void bite(Character other) {
        //DO NOT CHANGE, Same for EVERY Monster
        int attackRoll = Die.rollDie("1d20");
        //+to hit
        attackRoll += 4;

        //Is bite successful?
        if(attackRoll >= other.getArmorClass()) {
            //Damage roll
            int damageRoll = Die.rollDie("1d4");
            //+ to damage
            damageRoll += 2;

            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " bites " + other.getName() + " for " + damageRoll + " damage");
        }
        else { //bite misses
            System.out.println(getName() + " attempts to bite " + other.getName() + " but misses.");
        }
    }
}
