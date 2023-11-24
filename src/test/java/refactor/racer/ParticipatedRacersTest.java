package refactor.racer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ParticipatedRacersTest {
    private static Stream<Arguments> generateRacers() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        Racer.of(RacerName.from("성훈"), RacerPosition.from(1)),
                        Racer.of(RacerName.from("포비"), RacerPosition.from(2)),
                        Racer.of(RacerName.from("혜림"), RacerPosition.from(3))
                        ), new String[]{"혜림"}
                ),
                Arguments.of(
                        Arrays.asList(
                                Racer.of(RacerName.from("성훈"), RacerPosition.from(1)),
                                Racer.of(RacerName.from("포비"), RacerPosition.from(3)),
                                Racer.of(RacerName.from("혜림"), RacerPosition.from(2))
                        ), new String[]{"포비"}
                ),
                Arguments.of(
                        Arrays.asList(
                                Racer.of(RacerName.from("성훈"), RacerPosition.from(2)),
                                Racer.of(RacerName.from("포비"), RacerPosition.from(1)),
                                Racer.of(RacerName.from("혜림"), RacerPosition.from(2))
                        ), new String[]{"성훈", "혜림"}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateRacers")
    void flow(List<Racer> racerList, String[] expectedWinnerNames) {
        ParticipatedRacers racers = ParticipatedRacers.from(racerList);

        List<Racer> winners = racers.findWinner();
        List<String> winnerNames = winners.stream()
                .map(Racer::getRacerNameValue)
                .toList();

        assertThat(winnerNames).containsExactly(expectedWinnerNames);
    }
}
