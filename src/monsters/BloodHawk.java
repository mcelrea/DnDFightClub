package monsters;

import character.Monster;
import character.Character;
import dnd.Die;
public class BloodHawk extends Monster {

    public BloodHawk(String name) {
        super(name,
                12,
                -2,
                +2,
                +0,
                -4,
                +2,
                -3,
                "2d6");
    }

    public void beak(Character other) {
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 4;

        //Is beak successful?
        if(attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d4");
            damageRoll += 2;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " peck " + other.getName() + " for " + damageRoll + " damage");
        }
        else { //peck misses
            System.out.println(getName() + " attempts to peck " + other.getName() + " but misses.");
        }
    }
}