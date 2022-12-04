package pairmatching.config;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();

    public String getPairMatchFeat() {
        outputView.printStartMatch();
        return Console.readLine();
    }

    public String getPairMenu() {
        outputView.printMatchMenu();
        outputView.printSelectMatch();
        return Console.readLine();
    }

    public String getPairMenuWhenExist() {
        outputView.printSelectMatch();
        return Console.readLine();
    }

    public String getRematch() {
        outputView.printExistMatchHistory();
        return Console.readLine();
    }
}
