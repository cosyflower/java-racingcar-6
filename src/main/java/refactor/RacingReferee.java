package refactor;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import refactor.racer.ParticipatedRacers;
import refactor.racer.Racer;

public class RacingReferee {
    public static ParticipatedRacers executeEachRound(ParticipatedRacers participatedRacers,
                                                      Supplier<Integer> numberSupplier) {
        ParticipatedRacers movedParticipatedRacers =
                participatedRacers.checkEachLap(numberSupplier);
        return movedParticipatedRacers;
    }

    public static Map<String, Integer> getEachRoundStatus(ParticipatedRacers participatedRacers) {
        List<Racer> racers = participatedRacers.getParticipatedRacers();
        return racers.stream()
                .collect(Collectors.toMap(Racer::getRacerNameValue, Racer::getRacerPositionValue));
    }

    public static List<String> getWinnerNames(ParticipatedRacers participatedRacers) {
        List<Racer> winners = participatedRacers.findWinner();
        return winners.stream()
                .map(Racer::getRacerNameValue)
                .toList();
    }

}
