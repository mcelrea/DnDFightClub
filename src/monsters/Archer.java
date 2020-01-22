package monsters;

import character.Character;
import character.Monster;
import dnd.Die;

public class Archer extends Monster {

    public Archer(String name) {
        super(name, 16, +0, +4, +3, +0, +1, +0, "10d8" + 30);
    }

    public void shortsword(Character other){
        //Do not change, same for every monster
        int chanceOfHitting = Die.rollDie("1d20");
        //+ to hit
        chanceOfHitting += 6;

        //Was bite successful?
        if(chanceOfHitting >= other.getArmorClass()){
            //damage roll
            int damageRoll = Die.rollDie("1d6");
            //+ to damage
            damageRoll += 4;

            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " slashes (shortsword) " + other.getName() + " for " + damageRoll + " damage");
        }else{ //bite misses
            System.out.println(getName() + " attempts to shortsword " + other.getName() + ", but misses.");
        }
    }

    public void longBow(Character other){
        //Do not change, same for every monster
        int chanceOfHitting = Die.rollDie("1d20");
        //+ to hit
        chanceOfHitting += 6;

        //Was bite successful?
        if(chanceOfHitting >= other.getArmorClass()){
            //damage roll
            int damageRoll = Die.rollDie("1d8");
            //+ to damage
            damageRoll += 4;

            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " slashes (Longbow) " + other.getName() + " for " + damageRoll + " damage");
        }else{ //bite misses
            System.out.println(getName() + " attempts to Longbow " + other.getName() + ", but misses.");
        }
    }
}