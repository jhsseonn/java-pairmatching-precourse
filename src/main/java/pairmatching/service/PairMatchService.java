package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatchService {

    public List<String> backCrewList = new ArrayList<>();
    public List<String> frontCrewList = new ArrayList<>();
    List<String> shuffledCrewList = new ArrayList<>();

    public List<String> getCrewList(String fileName) throws IOException {
        List<String> crewList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String str;
        while((str= reader.readLine())!=null) {
            crewList.add(str);
        }

        reader.close();

        shuffledCrewList = setRandomCrewList(crewList);

        return shuffledCrewList;
    }

    public List<String> setRandomCrewList(List<String> crew) {
        return Randoms.shuffle(crew);
    }
}
