package javase02.t04;

import javase02.t01.Color;
import javase02.t01.Size;
import javase02.t02.Stationery.Eraser;
import javase02.t02.Stationery.Pen;
import javase02.t02.Stationery.Puncher;
import javase02.t02.Stationery.Stationery;
import javase02.t04.Comparators.StarterPackComparatorByName;
import javase02.t04.Comparators.StarterPackComparatorByPrice;

import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        List<Stationery> stationeryTestSortByName1 = new ArrayList<>();


        Pen pen1 = new Pen("ZPen", Color.RED, Size.MIDDLE,Boolean.TRUE,10.0);
        Pen pen2 = new Pen("APen", Color.RED, Size.MIDDLE,Boolean.TRUE,10.0);
        Pen pen3 = new Pen("APenLowPrice", Color.RED, Size.MIDDLE,Boolean.TRUE,9.0);
        Eraser eraser1 = new Eraser("ZEraser", Size.MIDDLE,10.0);
        Eraser eraser2 = new Eraser("AEraser", Size.MIDDLE,10.0);
        Eraser eraser3 = new Eraser("AEraserLowPrice", Size.MIDDLE,9.0);
        Puncher puncher1 = new Puncher("ZPuncher",10.0,Color.RED,Size.MIDDLE);
        Puncher puncher2 = new Puncher("APuncher",10.0,Color.RED,Size.MIDDLE);
        Puncher puncher3 = new Puncher("APuncherLowPrice",9.0,Color.RED,Size.MIDDLE);
        Puncher puncher4 = new Puncher("Puncher",190.0,Color.RED,Size.MIDDLE);
        Puncher puncher5 = new Puncher("Puncher",9.0,Color.RED,Size.MIDDLE);

        stationeryTestSortByName1.add(pen1);
        stationeryTestSortByName1.add(pen2);
        stationeryTestSortByName1.add(pen3);
        stationeryTestSortByName1.add(eraser1);
        stationeryTestSortByName1.add(eraser2);
        stationeryTestSortByName1.add(eraser3);
        stationeryTestSortByName1.add(puncher1);
        stationeryTestSortByName1.add(puncher2);
        stationeryTestSortByName1.add(puncher3);
        stationeryTestSortByName1.add(puncher4);
        stationeryTestSortByName1.add(puncher5);


        List<Stationery> stationeryTestSortByPrice2 = new ArrayList<>(stationeryTestSortByName1);
        List<Stationery> stationeryTestSortByNameAndPrice3= new ArrayList<>(stationeryTestSortByName1);


        System.out.println("SortByName");
        stationeryTestSortByName1.sort(Stationery::compareTo);
        for(Stationery i: stationeryTestSortByName1)
        {
            System.out.println(String.format("Name : %s and Price = %f",i.getName(),i.getPrice()));
        }

        System.out.println("\nSortByPrice");
        StarterPackComparatorByPrice comparatorTest = new StarterPackComparatorByPrice();
        stationeryTestSortByPrice2.sort(comparatorTest);
        for(Stationery i: stationeryTestSortByPrice2)
        {
            System.out.println(String.format("Name : %s and Price = %f",i.getName(),i.getPrice()));
        }

        System.out.println("\nSortByNameAndPrice");
        comparatorTest.thenComparing(new StarterPackComparatorByName());
        stationeryTestSortByNameAndPrice3.sort(comparatorTest);
        for(Stationery i: stationeryTestSortByNameAndPrice3)
        {
            System.out.println(String.format("Name : %s and Price = %f",i.getName(),i.getPrice()));
        }

    }
}
