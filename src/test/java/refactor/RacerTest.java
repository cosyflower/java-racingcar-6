package refactor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacerTest {
    @Test
    void createRacer() {
        Racer racer = Racer.of(RacerName.from("성훈"), RacerPosition.from(3));

        assertThat(racer.getRacerNameValue()).isEqualTo("성훈");
        assertThat(racer.getRacerPositionValue()).isEqualTo(3);
    }

    @Test
    void moveWhenBiggerThanFour() {
        Racer racer = Racer.of(RacerName.from("성훈"), RacerPosition.from(3));
        Racer movedRacer = racer.move(() -> 4);

        assertThat(movedRacer.getRacerPositionValue()).isEqualTo(4);
    }
}
