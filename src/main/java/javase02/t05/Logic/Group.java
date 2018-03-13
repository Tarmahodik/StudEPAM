package javase02.t05.Logic;

import javase02.t05.Enums.Subjects;

import java.util.ArrayList;
import java.util.List;

public class Group<T extends Number>
{

    private Subjects subject;
    private List<StudentWithMark> students = new ArrayList<>();


    public Group(Subjects subject)
    {
        this.subject = subject;
    }

    class StudentWithMark<T extends Number>
    {
        private Student student;

        public T getMark()
        {
            return mark;
        }

        public void setMark(T mark) {
            this.mark = mark;
        }

        private T mark = null;

        StudentWithMark(Student student)
        {
            this.student = student;
        }

    }

}
