package menu.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;

public class StringToMenusConverter implements Converter<String, List<Menu>> {
    @Override
    public List<Menu> convert(String source) {
        String[] menuNames = source.split(",");
        if (menuNames.length > 2) {
            throw new IllegalArgumentException("최대 2개까지 입력할 수 있습니다.");
        }
        return Arrays.stream(menuNames)
                .map(menuName -> Category.findMenu(menuName.trim()))
                .collect(Collectors.toList());
    }
}
