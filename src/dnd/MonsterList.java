package dnd;

import character.Monster;
import monsters.Cultist;
import monsters.GiantCrab;
import monsters.GiantRat;
import monsters.Orc;

import java.util.ArrayList;

public class MonsterList {
    private ArrayList<Monster> monsters;

    public MonsterList() {
        monsters = new ArrayList<Monster>();

        monsters.add(new GiantRat("Rat 1"));
        monsters.add(new GiantRat("Rat 2"));
        monsters.add(new GiantRat("Rat 3"));
        monsters.add(new Orc("Henry"));
        monsters.add(new Orc("Patrick"));
        monsters.add(new Orc("Angry"));
        monsters.add(new Cultist("Neil"));
        monsters.add(new Cultist("Bob"));
        monsters.add(new Cultist("Rand"));
    }

    public ArrayList<Monster> getAllMonstersInCR(double rating) {
        ArrayList<Monster> list = new ArrayList<Monster>();
        //for loop through monsters ArrayList
        for(int i=0; i < monsters.size(); i++) {
            //look at the CR of the current monster
            double currentCR = monsters.get(i).getCr();
            //if its CR matches rating then
            if(Math.abs(currentCR - rating) < 0.01) {
                //add the monster to the list
                list.add(monsters.get(i));
            }
        }

        //return the list
        return list;
    }

    public Monster getRandomMonsterInCR(double rating) {
        //get all the monsters in that CR (see method above)
        ArrayList<Monster> list = getAllMonstersInCR(rating);

        //check to see if there are NO monsters in list
        if(list.size() == 0) {
            return null;
        }

        //get a random number between 0-size of ArrayList
        int randomNum = (int)(Math.random() * list.size());

        //return the monster at the random number index
        return list.get(randomNum);
    }

    public void removeMonster(Monster m) {
        monsters.remove(m);
    }
}
