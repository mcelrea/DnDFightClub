import character.Monster;
import character.Player;
import dnd.Die;
import dnd.MonsterList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner buffer = new Scanner(System.in);
        MonsterList monsters = new MonsterList();

        Player player = new Player("Thierry",
                16,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                "1d10");
        System.out.println("Temporary text lines");
        System.out.println("You can remove these");
        System.out.print("Creating new player...");
        //Thread.sleep(1000);
        System.out.print("...");
        //Thread.sleep(1000);
        System.out.println("...");
        //Thread.sleep(1000);
        System.out.println("Character created!!");
        System.out.println("-------------------------------");
        //Thread.sleep(500);
        System.out.println(player);

        Monster currentMonster = null;
        while(player.isAlive()) {
            //we need a Monster to attack, how do we choose this Monster
                //we need a skill rating for the player so we know what
                //monster to throw at them...

            if(currentMonster == null || !currentMonster.isAlive()) {
                if (player.getLevel() == 1) {
                    currentMonster = monsters.getRandomMonsterInCR(0.125);
                }
            }
            if(currentMonster != null) {
                player.attack(currentMonster);
                if(!currentMonster.isAlive()) {
                    monsters.removeMonster(currentMonster);
                }
                else { //monster is still alive
                    currentMonster.attack(player);
                }
            }
            else {//current monster is NULL
                System.out.println("ERROR: NO MONSTER TO ATTACK");
                break;
            }
            Thread.sleep(100);
        }
    }
}
