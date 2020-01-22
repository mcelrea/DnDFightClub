package monsters;

import character.Character;
import character.Monster;
import dnd.Die;

public class AmbushDrake extends Monster {


    public AmbushDrake(String name) {
        super(name, 13, +1, +2, +2, -3, +0, -2, "4d6");
        super.setHitPoints(getHitPoints() + 8);
    }

    public void bite(Character other) {
        //DO NOT CHANGE, SAME FOR EVERY MONSTER
        int attackRoll = Die.rollDie("1d20");
        // + to hit
        attackRoll += 4;

        //Is bite successful?
        if(attackRoll >= other.getArmorClass()){
            int damageRoll = Die.rollDie("1d6");
            damageRoll += 1;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " bites " + other.getName() + " for " + damageRoll + " damage");

        }
        else{ //bite misses
            System.out.println(getName() + " attempts to bite " + other.getName() + " but misses.");
        }
    }

}