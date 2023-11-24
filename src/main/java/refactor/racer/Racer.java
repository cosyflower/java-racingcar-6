package refactor.racer;

import java.util.function.Supplier;

public class Racer implements Comparable<Racer> {
    private static final int GREEN_LIGHT_VALUE = 4;
    private final RacerName racerName;
    private final RacerPosition racerPosition;

    private Racer(RacerName name, RacerPosition position) {
        this.racerName = name;
        this.racerPosition = position;
    }

    public static Racer of(RacerName racerName, RacerPosition racerPosition) {
        return new Racer(racerName, racerPosition);
    }

    public Racer move(Supplier<Integer> randomSupplier) { // random으로 수를 받아야 한다 - pickNumberInRange() 로 작성한다
        if (randomSupplier.get() >= GREEN_LIGHT_VALUE) {
            RacerPosition movedRacePosition = this.racerPosition.moveForward();
            return Racer.of(racerName, movedRacePosition);
        }
        return this;
    }

    public boolean hasSamePosition(Racer racerWithMaxPosition) {
        return racerPosition.hasSameValue(racerWithMaxPosition.racerPosition);
    }

    @Override
    public int compareTo(Racer otherRacer) {
        return racerPosition.getPositionValue() - otherRacer.getRacerPositionValue();
    }

    public String getRacerNameValue() {
        return racerName.getRacerNameValue();
    }

    public int getRacerPositionValue() {
        return racerPosition.getPositionValue();
    }
}
