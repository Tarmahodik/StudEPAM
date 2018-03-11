package javase02.t04;

import javase02.t01.Color;
import javase02.t01.Size;
import javase02.t02.Stationery.Eraser;
import javase02.t02.Stationery.Pen;
import javase02.t02.Stationery.Puncher;
import javase02.t02.Stationery.Stationery;
import javase02.t03.StarterPack;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        Pen pen = new Pen("Zpen",Color.BLUE,Size.BIG,Boolean.TRUE,10.0);
        Puncher puncher = new Puncher("Zpen",9.0,Color.RED,Size.MIDDLE);
        Eraser eraser = new Eraser("Aeraser",Size.MIDDLE,11.0);

        StarterPack starterpack1 = new StarterPack(puncher,pen,eraser);
        
        starterpack1.sortByName();
        starterpack1.sortByPrice();
        starterpack1.sortByNameAndPrice();

    }
}
