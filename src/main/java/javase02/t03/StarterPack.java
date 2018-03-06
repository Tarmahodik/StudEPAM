package javase02.t03;

import javase02.t02.Stationery.Eraser;
import javase02.t02.Stationery.Pen;
import javase02.t02.Stationery.Puncher;
import javase02.t02.Stationery.Stationery;
import org.apache.logging.log4j.util.PropertySource;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StarterPack
{
    private List<Stationery> starterPackStationery;


    private StarterPack(Stationery ... args)
    {
        starterPackStationery = new ArrayList<>();
        Collections.addAll(starterPackStationery, args);
    }

    public StarterPack(@NotNull Puncher puncher ,@NotNull Pen pen , @NotNull Eraser eraser)
    {
        this(pen,puncher,eraser);
    }


    private void printAllElementsInStarterPack()
    {
        for(Stationery i : starterPackStationery)
        {
            System.out.print(String.format("\nName : %s\nPrice : %s",i.getName(),i.getPrice()));
        }
        System.out.println("\n");
    }

    public void sortByName()
    {

        class SorterByName implements Comparator<Stationery>
        {
            @Override
            public int compare(Stationery o1, Stationery o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        }

        starterPackStationery.sort(new SorterByName());
        printAllElementsInStarterPack();
    }

    public void sortByPrice()
    {

        class SorterByPrice implements Comparator<Stationery>
        {
            @Override
            public int compare(Stationery o1, Stationery o2)
            {
                return (int) (o1.getPrice()-o2.getPrice());
            }
        }

        starterPackStationery.sort(new SorterByPrice());
        printAllElementsInStarterPack();
    }

    public void sortByNameAndPrice()
    {
        starterPackStationery.sort(((Comparator<Stationery>) (o1, o2) -> o1.getName().compareTo(o2.getName())).thenComparing((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())));
        printAllElementsInStarterPack();
    }

}
