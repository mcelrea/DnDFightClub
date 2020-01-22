package monsters;

import character.Monster;
import dnd.Die;
import character.Character;

public class GiantCrab extends Monster {
    public GiantCrab(String name) {
        super(name, 15, +1, +2, +0, -5, -1, -3, "3d8");
    }
    public void claw(Character other){
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 3;

        //Is bite successful?
        if(attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d6");
            damageRoll += 1;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " Claws at " + other.getName() + " for " + damageRoll + " damage");
        }
        else { //bite misses
            System.out.println(getName() + " attempts claw " + other.getName() + " but misses.");
        }
    }
}