package refactor.racer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class ParticipatedRacers {
    private final List<Racer> participatedRacers;

    private ParticipatedRacers(List<Racer> participatedRacers) {
        this.participatedRacers = new ArrayList<>(participatedRacers);
    }

    public static ParticipatedRacers from(List<Racer> participatedRacers) {
        return new ParticipatedRacers(participatedRacers);
    }

    public ParticipatedRacers checkEachLap(Supplier<Integer> numberSupplier) {
        List<Racer> movedRacers = participatedRacers.stream()
                .map(racer -> racer.move(numberSupplier))
                .toList();
        return ParticipatedRacers.from(movedRacers);
    }

    public List<Racer> findWinner() {
        Racer racerWithMaxPosition = findMaxPositionCar();
        return participatedRacers.stream()
                .filter(racer -> racer.hasSamePosition(racerWithMaxPosition))
                .toList();
    }

    private Racer findMaxPositionCar() {
        return participatedRacers.stream()
                .max(Racer::compareTo)
                .get();
    }

    public List<Racer> getParticipatedRacers() {
        return Collections.unmodifiableList(participatedRacers);
    }
}
