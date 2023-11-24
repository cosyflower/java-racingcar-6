package refactor.numberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    void 범위내_숫자인지_검증() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int number = numberGenerator.generateNumber();

        assertThat(number).isBetween(0, 9);
    }
}
