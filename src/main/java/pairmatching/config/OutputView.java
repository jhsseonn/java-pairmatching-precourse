package pairmatching.config;

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

    public void printMatchResult() {
        System.out.print(MATCH_RESULT);
    }

    public void printExistMatchHistory() {
        System.out.print(EXIST_MATCH_HISTORY);
    }

    public void printResetMatch() {
        System.out.print(RESET_MATCH);
    }
}
