package pairmatching.domain;

import java.util.List;

public class PairMatching {
    public Course course;
    public Level level;
    public List<String> crew;

    PairMatching(Course course, Level level, List<String >crew) {
        this.course = course;
        this.level = level;
        this.crew = crew;
    }


}
