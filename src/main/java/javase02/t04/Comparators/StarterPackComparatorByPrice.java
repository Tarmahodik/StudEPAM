package javase02.t04.Comparators;

import javase02.t02.Stationery.Stationery;

import java.util.Comparator;

public class StarterPackComparatorByPrice implements Comparator<Stationery>
{

    @Override
    public int compare(Stationery o1, Stationery o2)
    {
        return (int) (o1.getPrice()-o2.getPrice());
    }
}
