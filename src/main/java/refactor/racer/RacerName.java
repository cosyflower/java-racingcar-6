package refactor.racer;

import java.util.Objects;

public class RacerName {
    public final String racerNameValue;

    private RacerName(String racerNameValue) {
        this.racerNameValue = racerNameValue;
    }

    public static RacerName from(String racerNameValue) {
        return new RacerName(racerNameValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacerName racerName = (RacerName) o;
        return Objects.equals(racerNameValue, racerName.racerNameValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerNameValue);
    }

    public String getRacerNameValue() {
        return racerNameValue;
    }
}
