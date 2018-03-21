package javase02.t05;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group<T extends Number & Comparable<? super T>> {
    @Getter
    private Discipline discipline;
    private T min,
            max;
    private HashMap<Student, Journal<T>> studentsEvaluations;

     Group(Discipline discipline, T min, T max) {
        this.discipline = discipline;
        this.min = min;
        this.max = max;
        this.studentsEvaluations = new HashMap<>();
    }

    public Journal getJournal(Student student) {
        return studentsEvaluations.get(student);
    }

    public void addMark(Student student, T mark) {
        if (mark.compareTo(min) < 0 || mark.compareTo(max) > 0)
            return;
        if (studentsEvaluations.containsKey(student))
            studentsEvaluations.get(student)
                    .addMark(mark);
        else {
            Journal evals = new Journal();
            evals.addMark(mark);
            studentsEvaluations.put(student, evals);
        }
    }

    public boolean removeMark(Student student, Mark<Float> mark) {
        return studentsEvaluations.get(student)
                .removeMark(mark);
    }
}