package pairmatching.controller;

import pairmatching.config.InputView;
import pairmatching.config.StringParams;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;
import pairmatching.service.PairMatchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        List<String> crewList = new ArrayList<>();
        if (checkIsCourseAvailable(matchFeatList[0]) && checkIsLevelAvailable(matchFeatList[1])) {
            if (existsMission(matchFeatList[2], matchFeatList[1])) {
                crewList = checkCourse(matchFeatList[0]);
            }
        }

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

    public Boolean checkIsCourseAvailable(String chosenCourse) {
        boolean isAvailable = false;
        if (chosenCourse.equals((Course.valueOf("BACKEND")).getName())) {
            isAvailable = true;
        }
        if (chosenCourse.equals((Course.valueOf("FRONTEND")).getName())) {
            isAvailable = true;
        }
        //일치하는 경우가 없을시(isAvailable이 false일 시) 에러메시지 출력 필요
        return isAvailable;
    }

    public Boolean checkIsLevelAvailable(String chosenLevel) {
        boolean isAvailable = false;
        List<String> levelNames = new ArrayList<>();
        for (Level level:Level.values()){
            levelNames = Collections.singletonList(level.getName());
        }
        isAvailable = existsLevel(chosenLevel, levelNames);
        return isAvailable;
    }

    public Boolean existsLevel(String chosenLevel, List<String> levelList) {
        boolean isAvailable = false;
        for (String levelName : levelList) {
            if (chosenLevel.equals((Level.valueOf(levelName)).getName())) {
                isAvailable = true;
                break;
            }
        }
        //일치하는 경우가 없을시(isAvailable이 false일 시) 에러메시지 출력 필요

        return isAvailable;
    }

    public Boolean existsMission(String mission, String level) {
        boolean isAvailable = false;
        List<String> missionNames = new ArrayList<>();
        for (Mission missions: Mission.values()) {
            missionNames = Collections.singletonList(missions.getName());
        }
        for (String missionName: missionNames) {
            if (mission.equals((Mission.valueOf(missionName)).getName()) && level.equals((Mission.valueOf(missionName)).getLevel())) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public List<List<String>> getPairMatchingList(List<String> crewList) {
        List<List<String>> pairMatchList = new ArrayList<>();
        int crewNumber = 0;
        if(crewList.size()%2==0) {
            while(crewNumber<crewList.size()) {
                List<String> pair = new ArrayList<>();
                pair.add(crewList.get(crewNumber));
                pair.add(crewList.get(crewNumber+1));
                pairMatchList.add(pair);
                crewNumber+=2;
            }
        }
        if(crewList.size()%2!=0) {
            while(crewNumber<crewList.size()) {
                if (crewNumber==crewList.size()-1) {
                    List<String> pair = pairMatchList.get(pairMatchList.size()-1);
                    pair.add(crewList.get(crewNumber));
                    pairMatchList.add(pairMatchList.size()-1, pair);
                }
                List<String> pair = new ArrayList<>();
                pair.add(crewList.get(crewNumber));
                pair.add(crewList.get(crewNumber+1));
                pairMatchList.add(pair);
                crewNumber+=2;
            }
        }

        return pairMatchList;
    }

}
