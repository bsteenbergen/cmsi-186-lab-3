import java.util.Random;

public class Die {
    private static Random random = new Random();

        public static final String SIX_SIDED_DIE_EMOJI = "🎲";

        private final int sides;
        private int value;

    public Die(int sides, int value) {
        this.sides = sides;
        this.value = value;

        if (sides < 4) {
            throw new IllegalArgumentException("At least four sides required");
        }

        if (value > sides || value < 1) {
            throw new IllegalArgumentException("Die value not legal for die shape");
        }
    }

    public int roll() {
        value = random.nextInt(sides) + 1;
        return value;
    }

    public int getSides() {
        return sides;
    }

    public int getValue() {
        return value;
    }

    @Override public String toString() {
        return "[" + value + "]";
    }
}
