package refactor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import refactor.numberGenerator.RandomNumberGenerator;
import refactor.racer.ParticipatedRacers;
import refactor.racer.Racer;
import refactor.racer.RacerName;
import refactor.racer.RacerPosition;

public class RacingRefereeTest {
    @Test
    void flow() {
        ParticipatedRacers participatedRacers = ParticipatedRacers.from(
                Arrays.asList(Racer.of(RacerName.from("성훈"), RacerPosition.from(1)),
                        Racer.of(RacerName.from("혜림"), RacerPosition.from(1)),
                        Racer.of(RacerName.from("상호"), RacerPosition.from(1)),
                        Racer.of(RacerName.from("선응"), RacerPosition.from(1)))
        );

        ParticipatedRacers moved = RacingReferee.executeEachRound(participatedRacers,
                () -> new RandomNumberGenerator().generateNumber());
        Map<String, Integer> eachRoundStatus =
                RacingReferee.getEachRoundStatus(moved);

        for (String key : eachRoundStatus.keySet()) {
            System.out.println("key = " + key);
            System.out.println("eachRoundStatus.get(key) = " + eachRoundStatus.get(key));
        }
    }

    @Test
    void winnerNames() {
        ParticipatedRacers participatedRacers = ParticipatedRacers.from(
                Arrays.asList(Racer.of(RacerName.from("성훈"), RacerPosition.from(1)),
                        Racer.of(RacerName.from("혜림"), RacerPosition.from(2)),
                        Racer.of(RacerName.from("상호"), RacerPosition.from(2)),
                        Racer.of(RacerName.from("선응"), RacerPosition.from(3)))
        );

        ParticipatedRacers moved = RacingReferee.executeEachRound(participatedRacers, () -> 4);
        Map<String, Integer> eachRoundStatus =
                RacingReferee.getEachRoundStatus(moved);
        List<String> winnerNames = RacingReferee.getWinnerNames(moved);

        for (String winnerName : winnerNames) {
            System.out.println("winnerName = " + winnerName);
        }

    }
}
