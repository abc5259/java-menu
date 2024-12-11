package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN(1, "일식", List.of(
            new Menu("규동"),
            new Menu("우동"),
            new Menu("미소시루"),
            new Menu("스시"),
            new Menu("가츠동"),
            new Menu("오니기리"),
            new Menu("하이라이스"),
            new Menu("라멘"),
            new Menu("오코노미야끼")
    )),
    //김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    KOREA(2, "한식", List.of(
            new Menu("김밥"),
            new Menu("김치찌개"),
            new Menu("쌈밥"),
            new Menu("된장찌개"),
            new Menu("비빔밥"),
            new Menu("칼국수"),
            new Menu("불고기"),
            new Menu("떡볶이"),
            new Menu("제육볶음")
    )),
    CHINA(3, "중식", List.of(
            new Menu("깐풍기"),
            new Menu("볶음면"),
            new Menu("동파육"),
            new Menu("짜장면"),
            new Menu("짬뽕"),
            new Menu("마파두부"),
            new Menu("탕수육"),
            new Menu("토마토 달걀볶음"),
            new Menu("고추잡채")
    )),
    ASIAN(4, "아시안", List.of(
            new Menu("팟타이"),
            new Menu("카오 팟"),
            new Menu("나시고렝"),
            new Menu("파인애플 볶음밥"),
            new Menu("쌀국수"),
            new Menu("똠얌꿍"),
            new Menu("반미"),
            new Menu("월남쌈"),
            new Menu("분짜")
    )),
    WESTERN(5, "양식", List.of(
            new Menu("라자냐"),
            new Menu("그라탱"),
            new Menu("뇨끼"),
            new Menu("끼슈"),
            new Menu("프렌치 토스트"),
            new Menu("바게트"),
            new Menu("스파게티"),
            new Menu("피자"),
            new Menu("파니니")
    ));

    private final int symbol;
    private final String name;
    private final List<Menu> menus;

    Category(int symbol, String name, List<Menu> menus) {
        this.symbol = symbol;
        this.name = name;
        this.menus = menus;
    }

    public static Category findBySymbol(int symbol) {
        return Arrays.stream(Category.values())
                .filter(category -> category.isEqualSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 카테코리를 찾을 수 없습니다."));
    }

    public static Menu findMenu(String menuName) {
        Menu findMenu = new Menu(menuName);
        return Arrays.stream(Category.values())
                .flatMap(category -> category.menus.stream())
                .filter(menu -> menu.equals(findMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("메뉴를 찾을 수 없습니다."));
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }

    private boolean isEqualSymbol(int symbol) {
        return this.symbol == symbol;
    }
}
