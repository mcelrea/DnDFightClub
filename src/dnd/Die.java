package dnd;

public class Die {

    public static int rollDie(String die) {
        int loc = die.indexOf("d");
        int numOfDie = Integer.parseInt(die.substring(0,loc));
        int typeOfDice = Integer.parseInt(die.substring(loc+1));
        //System.out.println("Number of dice: " + numOfDie);
        //System.out.println("Type of die: " + typeOfDice);

        int total = 0;
        for(int i=0; i < numOfDie; i++) {
            total += 1 + Math.random() * typeOfDice;
        }

        return total;
    }
}
