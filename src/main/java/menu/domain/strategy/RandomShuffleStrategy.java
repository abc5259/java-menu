package menu.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomShuffleStrategy implements ListShuffleStrategy {
    @Override
    public List<String> shuffle(List<String> list) {
        return Randoms.shuffle(list);
    }
}
