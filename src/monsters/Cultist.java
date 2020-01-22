package monsters;

import character.Monster;
import character.Character;
import dnd.Die;

public class Cultist extends Monster {

    public Cultist(String name) {
        super(name,
                12,
                0,
                1,
                0,
                0,
                0,
                0,
                "2d8");
    }

    public void scimitar(Character other) {
        //DO NOT CHANGE, Same for EVERY Monster
        int attackRoll = Die.rollDie("1d20");
        // "+# to hit"
        attackRoll += 3;

        //Is scimitar successful?
        if(attackRoll >= other.getArmorClass()) {
            //Damage roll
            int damageRoll = Die.rollDie("1d6");
            // "+# to damage"
            damageRoll += 1;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " uses scimitar against " + other.getName() + " for " + damageRoll + " damage");
        }
        else { //scimitar misses
            System.out.println(getName() + " attempts to use scimitar against " + other.getName() + " but misses.");
        }
    }
}
