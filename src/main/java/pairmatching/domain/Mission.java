package pairmatching.domain;

public enum Mission {
    RACING("자동차경주", "레벨1"),
    LOTTO("로또", "레벨1"),
    BASEBALL("숫자야구게임", "레벨1"),
    MARKET("장바구니", "레벨2"),
    PAYMENT("결제", "레벨2"),
    SUBWAY("지하철노선도", "레벨2"),
    IMPROVEMENT("성능개선", "레벨4"),
    RELEASE("배포", "레벨4");

    private String name;
    private String level;

    Mission(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
