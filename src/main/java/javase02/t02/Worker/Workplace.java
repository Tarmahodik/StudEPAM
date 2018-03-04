package javase02.t02.Worker;

import javafx.concurrent.WorkerStateEvent;
import javase02.t02.Stationery.Stationery;

import java.util.ArrayList;
import java.util.List;

public class Workplace<T>
{
    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    private String owner;
    private List<Stationery> stationery;

    public Workplace(String owner)
    {
        this.owner=owner;
        stationery = new ArrayList<>();
    }

    public void addStationeryItem(Stationery item)
    {
        stationery.add(item);
    }

    public void deleteStationeryItem(Stationery item)
    {
        stationery.remove(item);
    }


    public void printAllStationery()
    {
        System.out.print(String.format("\nOwner : %s",owner));
        for (Stationery t : stationery)
        {
            System.out.print(t.toString());
        }
    }

    public void countAll()
    {
        double resultofCounting=0;

        for (Stationery t : stationery)
        {
            resultofCounting += t.getPrice();
        }
        System.out.print(String.format("\nOwner : %s",owner));
        System.out.print(String.format("\nTotal price : %f",resultofCounting));
    }


}
