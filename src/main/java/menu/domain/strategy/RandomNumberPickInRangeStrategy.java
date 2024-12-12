package menu.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPickInRangeStrategy implements NumberPickInRangeStrategy {
    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
