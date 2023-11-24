package refactor.numberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int RACING_CAR_START_INCLUSIVE = 0;
    public static final int RACING_CAR_END_INCLUSIVE = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(RACING_CAR_START_INCLUSIVE, RACING_CAR_END_INCLUSIVE);
    }
}
