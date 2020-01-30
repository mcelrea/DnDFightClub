package dnd;

public class Die {

    public static int rollDie(String die) {
        if(die.indexOf("+") == -1) {
            int loc = die.indexOf("d");
            int numOfDie = Integer.parseInt(die.substring(0, loc));
            int typeOfDice = Integer.parseInt(die.substring(loc + 1));
            //System.out.println("Number of dice: " + numOfDie);
            //System.out.println("Type of die: " + typeOfDice);

            int total = 0;
            for (int i = 0; i < numOfDie; i++) {
                total += 1 + Math.random() * typeOfDice;
            }

            return total;
        }
        else { //there was a + in the die roll
            int locOfD = die.indexOf("d");
            int numOfDie = Integer.parseInt(die.substring(0, locOfD));
            int locOfPlus = die.indexOf("+");
            int typeOfDice = Integer.parseInt(die.substring(locOfD+1, locOfPlus));
            int modifier = Integer.parseInt(die.substring(locOfPlus+1));

            int total = 0;
            for (int i = 0; i < numOfDie; i++) {
                total += 1 + Math.random() * typeOfDice;
            }
            total += modifier;
            return total;
        }
    }
}
