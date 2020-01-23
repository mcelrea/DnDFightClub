package monsters;

import character.Monster;
import character.Character;
import dnd.Die;

public class Orc extends Monster {

    public Orc(String name) {
        super(name, 13,+2,+1,+3,-2, 0, 0, "2d8");
        super.setHitPoints(super.getHitPoints()+6);
        super.setCr(0.5);
    }
    public void greatAxe (Character other) {
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 5;

        if (attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d12");
            damageRoll += 3;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " swings at " + other.getName() + " for " + damageRoll + " damage");
        }
        else {
            System.out.println(getName() + " attempts to swing at " + other.getName() + " but misses");
        }
    }

    public void javelin (Character other){
        int attackRoll = Die.rollDie("1d20");
        attackRoll += 5;

        if (attackRoll >= other.getArmorClass()) {
            int damageRoll = Die.rollDie("1d6");
            damageRoll += 3;
            other.setHitPoints(other.getHitPoints() - damageRoll);
            System.out.println(getName() + " throws a javelin at " + other.getName() + " for " + damageRoll + " damage");
        }
        else {
            System.out.println(getName() + " attempts to throw a javelin at" + other.getName() + " but misses");
        }
    }

    @Override
    public void attack(Character other) {
        int choice = Die.rollDie("1d2");
        if(choice == 1) {
            greatAxe(other);
        }
        else if (choice == 2) {
            javelin(other);
        }
    }
}
