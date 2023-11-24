package refactor.racer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import refactor.numberGenerator.NumberGenerator;
import refactor.numberGenerator.RandomNumberGenerator;

public class ParticipatedRacers {
    private final List<Racer> participatedRacers;

    private ParticipatedRacers(List<Racer> participatedRacers) {
        this.participatedRacers = new ArrayList<>(participatedRacers);
    }

    public static ParticipatedRacers from(List<Racer> participatedRacers) {
        return new ParticipatedRacers(participatedRacers);
    }

    // 라운드 진행하기 -> checkEachNap (각각 진행한다)
    public void checkEachLap() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        participatedRacers.forEach(
                racer -> racer.move(randomNumberGenerator::generateNumber)
        );
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
