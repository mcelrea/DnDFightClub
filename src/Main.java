import character.Player;
import dnd.Die;
import monsters.GiantRat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner buffer = new Scanner(System.in);


        GiantRat r1 = new GiantRat("Rat 1");
        GiantRat r2 = new GiantRat("Rat 2");
        Player player = new Player("Thierry",
                16,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                (Die.rollDie("1d20")-10)/2,
                "1d10");
        System.out.print("Creating new player...");
        Thread.sleep(1000);
        System.out.print("...");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("Character created!!");
        System.out.println("-------------------------------");
        Thread.sleep(500);
        System.out.println(player);

        while (player.getHitPoints() > 0 && r1.getHitPoints() > 0) {
            System.out.print("Enter player action: ");
            String playerInput = buffer.nextLine();
            if(playerInput.equals("shortsword")) {
                player.shortsword(r1);
            }
            Thread.sleep(1000);
            if(r1.isAlive()) {
                r1.bite(player);
                Thread.sleep(1000);
            }
        }

        if(player.isAlive()) {
            Thread.sleep(1000);
            System.out.println("\n\n");
            System.out.println(player.getName() + " IS VICTORIOUS!!!");
        }
        else {
            Thread.sleep(1000);
            System.out.println("\n\n");
            System.out.println(player.getName() + " DIES A HORRIBLE, INFECTED, UGLY, PITIFUL DEATH!");
        }
    }
}
