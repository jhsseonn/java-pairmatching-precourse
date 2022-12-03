package pairmatching.config;

public class StringParams {
    public final static String BACK_CREW_LIST = "backend-crew.md";
    public final static String FRONT_CREW_LIST = "frontend-crew.md";
    public final static String START_MATCHING = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료\n";
    public final static String MATCH_MENU = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n";
    public final static String SELECT_MATCH = "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주\n";
    public final static String MATCH_RESULT = "페어 매칭 결과입니다.\n";
    public final static String EXIST_MATCH_HISTORY = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오\n";
    public final static String RESET_MATCH = "초기화 되었습니다.\n";
}
