package monsters;

import character.Monster;
import character.Character;
import dnd.Die;

public class Ixitxachitl extends Monster {

    public Ixitxachitl(String name){
        super(name, 15, 1, 3, 1, 1, 1, -2, "4d6");

    }
    public void bite(Character other){
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 3;
        if(attackRoll >= other.getArmorClass()){
            int damageRoll = Die.rollDie("1d6");
            damageRoll += 1;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " bites " + other.getName() + " for " + damageRoll + " damage!");
        }
        else{
            System.out.println(getName() + " tries to bite " + other.getName() + " but misses! There's another chance!");
        }
    }

    @Override
    public void attack(Character other) {

    }
}