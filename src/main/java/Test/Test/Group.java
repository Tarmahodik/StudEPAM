package Test.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Group<T extends Number>
{
    List<T> marks;
    Discipline discipline;

    Group(Discipline discipline)
    {
        this.discipline = discipline;

    }

}
