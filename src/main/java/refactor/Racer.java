package refactor;

import java.util.function.Supplier;

public class Racer {
    private final String name;
    private int position;

    public Racer(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(Supplier<Integer> randomSupplier) {
        if (randomSupplier.get() >= 4) {
            this.position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
