package javase02.t04.Comparators;

import javase02.t02.Stationery.Stationery;

import java.util.Comparator;

public class StarterPackComparatorByName implements Comparator<Stationery>
{
    @Override
    public int compare(Stationery o1, Stationery o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
