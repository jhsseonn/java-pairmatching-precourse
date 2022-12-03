package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.config.FileName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatchService {

    public void setRandomCrewList(List<String> crew) {
        Randoms.shuffle(crew);
    }
}
