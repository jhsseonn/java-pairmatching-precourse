package pairmatching.controller;

import pairmatching.config.InputView;
import pairmatching.config.StringParams;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairMatching;
import pairmatching.service.PairMatchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairMatchController extends StringParams {
    public Course course;
    public Level level;
    public PairMatching pairMatching;

    PairMatchService pairMatchService = new PairMatchService();

    InputView inputView = new InputView();

    public void pairMatchStart() throws IOException {
        String matchFeat = inputView.getPairMatchFeat();
        matchingFeature(matchFeat);
    }

    public void matchingFeature(String matchFeat) throws IOException {
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

    public void pairMatchCreate() throws IOException {
        String[] matchFeatList = (inputView.getPairMenu()).split(", ");
        HashMap<List<String>, List<String>> crewLists = new HashMap<>();

        List<String> crewList = checkCourse(matchFeatList[0]);
    }

    public void pairMatchRead() {

    }

    public void pairMatchReset() {

    }

    public void exitPairMatch() {

    }

    public List<String> checkCourse(String course) throws IOException{
        List<String> crewList = new ArrayList<>();
        if (course.equals((Course.valueOf("BACKEND")).getName())) {
            crewList = pairMatchService.getCrewList("src/main/resources/backend-crew.md");
        }
        if (course.equals((Course.valueOf("FRONT")).getName())) {
            crewList = pairMatchService.getCrewList("src/main/resources/frontend-crew.md");
        }
        return crewList;
    }

}
