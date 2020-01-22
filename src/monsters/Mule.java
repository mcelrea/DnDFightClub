package monsters;

import character.Monster;
import character.Character;
import dnd.Die;

public class Mule extends Monster {

    public Mule (String name) {
        super (name, 10,+2,0,+1,-4,0,-3,"2d8");

    }

    public void hooves(Character other) {
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 2;

        //Is hooves successful?
        if(attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d4");
            damageRoll += 2;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " hits " + other.getName() + " with its hooves for " + damageRoll + " damage.");
        }
        else { //hooves misses
            System.out.println(getName() + " attempts to use its hooves on " + other.getName() + " but misses.");
        }
    }
}
