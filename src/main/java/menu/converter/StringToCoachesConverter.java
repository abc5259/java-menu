package menu.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class StringToCoachesConverter implements Converter<String, List<Coach>> {
    private static final int MIN_COACH_LENGTH = 2;
    private static final int MAX_COACH_LENGTH = 5;

    @Override
    public List<Coach> convert(String source) {
        String[] coachNames = source.split(",");
        if (coachNames.length < MIN_COACH_LENGTH) {
            throw new IllegalArgumentException("코치는 최소 " + MIN_COACH_LENGTH + "명 이상 입력해야 합니다.");
        }
        if (coachNames.length > MAX_COACH_LENGTH) {
            throw new IllegalArgumentException("코치는 최대 " + MAX_COACH_LENGTH + "명 이하로 입력해야 합니다.");
        }
        return Arrays.stream(coachNames)
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
