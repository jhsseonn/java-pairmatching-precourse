package pairmatching.config;

import java.util.List;

public class OutputView extends StringParams{
    public void printStartMatch() {
        System.out.print(START_MATCHING);
    }

    public void printMatchMenu() {
        System.out.print(MATCH_MENU);
    }

    public void printSelectMatch() {
        System.out.print(SELECT_MATCH);
    }

    public void printMatchResult(List<List<String>> pairList) {
        System.out.print("\n"+MATCH_RESULT);
        for (List<String> pair: pairList) {
            if (pair.size()==3) {
                System.out.println(pair.get(0)+" : "+pair.get(1)+" : "+pair.get(2));
                break;
            }
            System.out.println(pair.get(0)+" : "+pair.get(1));
        }
    }

    public void cannotPairMatch() {
        System.out.println(ERROR+"페어 매칭에 실패했습니다.");
    }

    public void printExistMatchHistory() {
        System.out.print(EXIST_MATCH_HISTORY);
    }

    public void printResetMatch() {
        System.out.print(RESET_MATCH);
    }
}
