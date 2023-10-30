package racingcarv2.model;

public class RoundTotal {
    private static final String OVER_MAX_MESSAGE = "최대치를 넘긴 수를 입력했습니다";
    private final int roundTotalValue;

    public RoundTotal(int roundTotal) {
        validateNumberRange(roundTotal);
        this.roundTotalValue = roundTotal;
    }

    private void validateNumberRange(int roundTotal) {
        if (roundTotal > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(OVER_MAX_MESSAGE);
        }
    }

    public int getRoundTotalValue() {
        return roundTotalValue;
    }
}
