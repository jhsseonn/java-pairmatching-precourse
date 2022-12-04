package pairmatching.controller;

import pairmatching.config.InputView;
import pairmatching.config.StringParams;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairMatching;
import pairmatching.service.PairMatchService;

import java.util.List;

public class PairMatchController extends StringParams {
    public Course course;
    public Level level;
    public PairMatching pairMatching;

    public List<String> crewList;

    PairMatchService pairMatchService = new PairMatchService();

    InputView inputView = new InputView();

    public void pairMatchStart() {
        String matchFeat = inputView.getPairMatchFeat();
        matchingFeature(matchFeat);
    }

    public void matchingFeature(String matchFeat) {
        if (matchFeat.equals("1")) {
            pairMatchCreate();
        }
        if (matchFeat.equals("2")) {
            pairMatchRead();
        }
        if (matchFeat.equals("3")) {
            pairMatchReset();
        }
        if (matchFeat.equals("Q")) {
            exitPairMatch();
        }
    }

    public void pairMatchCreate() {

    }

    public void pairMatchRead() {

    }

    public void pairMatchReset() {

    }

    public void exitPairMatch() {

    }

}
