package weapons;

import character.Character;
import character.Player;
import dnd.Die;

public class Weapon {
    private String damageRoll;
    private String name;
    private boolean strengthModified;
    private int lastDamageRoll;

    public Weapon(String name, String damageRoll, boolean strengthModified) {
        this.name = name;
        this.damageRoll = damageRoll;
        this.strengthModified = strengthModified;
    }

    public String getDamageText(Character m) {
        return "You hit something";
    }

    public int getLastDamageRoll() {
        return lastDamageRoll;
    }

    public int attackRoll(Player player) {
        int result = Die.rollDie("1d20");
        if(strengthModified) {
            result += player.getStrength();
        }
        else {
            result += player.getDexterity();
        }
        return result;
    }

    public int damageRoll() {
        int damage = Die.rollDie(damageRoll);
        lastDamageRoll = damage;
        return damage;
    }
}
