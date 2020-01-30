package weapons;

import character.Character;
import character.Monster;

public class Bow extends Weapon{

    public Bow() {
        super("Longbow", "1d8+1", false);
    }

    @Override
    public String getDamageText(Character m) {
        if(getLastDamageRoll() == 2) {
            return "You grazed " + m.getName() + ", dealing " + getLastDamageRoll() + " damage.";
        }
        else if(getLastDamageRoll() <= 8) {
            return "You squarly hit " + m.getName() + ", dealing " + getLastDamageRoll() + " damage";
        }
        else { //critical hit
            return "You shot " + m.getName() + " straight through the eye dealing " + getLastDamageRoll() + " damage";
        }
    }
}
