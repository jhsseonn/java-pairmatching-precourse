package pairmatching.controller;

import pairmatching.config.InputView;
import pairmatching.config.OutputView;
import pairmatching.config.StringParams;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.service.PairMatchService;

import java.io.IOException;
import java.util.*;

public class PairMatchController extends StringParams {

    PairMatchService pairMatchService = new PairMatchService();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public HashMap<List<String>, List<List<String>>> crewLists = new HashMap<>();

    public void pairMatchStart() throws IOException {
        String matchFeat = inputView.getPairMatchFeat();
        matchingFeature(matchFeat);
    }

    public void matchingFeature(String matchFeat) throws IOException {
        if (matchFeat.equals("1")) {
            if (!pairMatchCreate()){
                outputView.cannotPairMatch();
            }
            pairMatchStart();
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

    public Boolean pairMatchCreate() throws IOException {
        int tryNumber = 0;
        boolean success = false;
        while(tryNumber<3) {
            tryNumber+=1;
            if (tryPairMatch()) {
                success=true;
                break;
            }
        }
        return success;
    }

    public Boolean tryPairMatch() throws IOException {
        boolean success = false;
        String[] matchFeatList = (inputView.getPairMenu()).split(", ");
        List<String> crewList;
        List<List<String>> pairMatchList;
        if (checkIsCourseAvailable(matchFeatList[0]) && checkIsLevelAvailable(matchFeatList[1])) {
            if (existsMission(matchFeatList[2], matchFeatList[1])) {
                crewList = checkCourse(matchFeatList[0]);
                pairMatchList = pairMatching(crewList);
                crewLists.put(Arrays.asList(matchFeatList), pairMatchList);
                outputView.printMatchResult(crewLists.get(Arrays.asList(matchFeatList)));
                success = true;
            }
        }
        return success;
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
        if (course.equals((Course.valueOf("FRONTEND")).getName())) {
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
            levelNames.add(level.getName());
        }
        isAvailable = existsLevel(chosenLevel, levelNames);
        return isAvailable;
    }

    public Boolean existsLevel(String chosenLevel, List<String> levelList) {
        boolean isAvailable = false;
        for (String levelName : levelList) {
            if (chosenLevel.equals(levelName)) {
                isAvailable = true;
                break;
            }
        }
        //일치하는 경우가 없을시(isAvailable이 false일 시) 에러메시지 출력 필요
        return isAvailable;
    }

    public Boolean existsMission(String mission, String level) {
        boolean isAvailable = false;
        List<Mission> missionEnums = new ArrayList<>(Arrays.asList(Mission.values()));
        for (Mission missions: missionEnums) {
            if (mission.equals(missions.getName()) && level.equals(missions.getLevel())) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public List<List<String>> pairMatching(List<String> crewList) {
        List<List<String>> pairMatchList = new ArrayList<>();
        int crewNumber = 0;
        pairMatchList = getPairMatchList(crewList, crewNumber, pairMatchList);

        return pairMatchList;
    }

    public List<List<String>> getPairMatchList(List<String> crewList, int crewNumber, List<List<String>> pairMatchList) {
        while(crewNumber<crewList.size()) {
            if (crewNumber==crewList.size()-1) {
                makeLastPair(pairMatchList, crewList, crewNumber);
                break;
            }
            makePair(crewList, crewNumber, pairMatchList);
            crewNumber+=2;
        }
        return pairMatchList;
    }

    public void makeLastPair(List<List<String>> pairMatchList, List<String> crewList, int crewNumber) {
        List<String> pair = pairMatchList.get(pairMatchList.size()-1);
        pair.add(crewList.get(crewNumber));
    }

    public void makePair(List<String> crewList, int crewNumber, List<List<String>> pairMatchList) {
        List<String> pair = new ArrayList<>();
        pair.add(crewList.get(crewNumber));
        pair.add(crewList.get(crewNumber+1));
        pairMatchList.add(pair);
    }

}
