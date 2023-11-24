package refactor.racer;

import java.util.Objects;

public class RacerPosition {
    public static final int FORWARD_VALUE = 1;
    private final int positionValue;

    private RacerPosition(int positionValue) {
        this.positionValue = positionValue;
    }

    public static RacerPosition from(int positionValue) {
        return new RacerPosition(positionValue);
    }

    public RacerPosition moveForward() {
        return RacerPosition.from(positionValue + FORWARD_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacerPosition that = (RacerPosition) o;
        return positionValue == that.positionValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionValue);
    }

    public int getPositionValue() {
        return positionValue;
    }
}
