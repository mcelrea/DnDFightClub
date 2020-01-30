package character;

import dnd.Die;
import weapons.Bow;
import weapons.ShortSword;
import weapons.Weapon;

import java.util.Scanner;

public class Player extends Character{

    private int level = 1;
    private Bow bow = new Bow();
    Scanner input = new Scanner(System.in);

    public Player(String name, int armorClass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String hitDie) {
        super(name, armorClass, strength, dexterity, constitution, intelligence, wisdom, charisma);
        setHitPoints(Die.rollDie(hitDie)+constitution);
        if(super.getHitPoints() < 5)
            super.setHitPoints(5);
        super.setMaxHitPoints(super.getHitPoints());
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void attack(Character other) {
        System.out.print("Enter type of attack: ");
        String attackType = input.nextLine();
        if(attackType.equals("bow")) {
            int attackRoll = bow.attackRoll(this);
            if(attackRoll >= other.getArmorClass()) {
                int damageRoll = bow.damageRoll();
                System.out.println(bow.getDamageText(other));
            }
        }
    }
}
