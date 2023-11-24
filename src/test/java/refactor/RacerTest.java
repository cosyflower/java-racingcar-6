package refactor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacerTest {
    @Test
    void createRacer() {
        Racer racer = new Racer("성훈", 3);

        assertThat(racer.getName()).isEqualTo("성훈");
        assertThat(racer.getPosition()).isEqualTo(3);
    }

    @Test
    void moveWhenBiggerThanFour() {
        Racer racer = new Racer("성훈", 3);
        racer.move(() -> 4);

        assertThat(racer.getPosition()).isEqualTo(4);
    }
}
