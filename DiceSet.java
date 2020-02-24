import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class DiceSet {

    private Die[] dice; //value is null

    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        if (numberOfDice < 2) {
        throw new IllegalArgumentException("At least two dice required");
        }

        if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least four sides");
        }

        this.dice = new Die[numberOfDice]; //creates the array
        for (var i = 0; i < dice.length; i++) {
            this.dice[i] = new Die(sidesOnEachDie, 1); //fills the array with die objects
        }
    }

    public DiceSet(int sidesOnEachDie, int... values) {
        if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least four sides");
        }

        if (values.length < 2) {
            throw new IllegalArgumentException("At least two dice required");
        }

        this.dice = new Die[values.length];
        for (var i = 0; i < dice.length; i++) {
            this.dice[i] = new Die(sidesOnEachDie, values[i]);
        }
    }

    public String descriptor() {
        return dice.length + "d" + dice[0].getSides();
    }

    public int sum() {
        var sum = 0;
        for (var i = 0; i < dice.length; i++) {
            sum += dice[i].getValue();
        }
        return sum;
    }

    public void rollAll() {
        for (var i = 0; i < dice.length; i++) {
            dice[i].roll();
        }
    }

    public void rollIndividual(int i) {
        dice[i].roll();
    }

    public int getIndividual(int i) {
        return dice[i].getValue();
    }

    public List<Integer> values() {
        var result = new ArrayList<Integer>();
        for (var i = 0; i < dice.length; i++) {
            result.add(dice[i].getValue());
        }
        return result;
    }

    /**
     * Returns whether this dice set has the same distribution of values as
     * an other dice set. The two dice sets must have the same number of dice
     * and the same number of sides per dice, and there must be the same
     * number of each value in each set.
     */
    public boolean isIdenticalTo(DiceSet diceSet) {
        return true;
    }

    @Override public String toString() {
        var result = "";
        for (var i = 0; i < dice.length; i++) {
            result += "[" + dice[i].getValue() + "]";
        }
        return result;
    }
}
