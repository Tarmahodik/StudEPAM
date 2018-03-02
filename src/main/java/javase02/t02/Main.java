package javase02.t02;

import javase02.t02.Stationery.Pen;
import javase02.t02.Stationery.Eraser;
import javase02.t02.Stationery.Stationery;
import javase02.t02.Worker.Workplace;

import static javase02.t01.Color.RED;
import static javase02.t01.Size.MIDDLE;

public class Main
{
    public static void main(String[] args)
    {
        Eraser someEraser = new Eraser(MIDDLE,RED,10.0);
        Pen somePen = new Pen(RED,MIDDLE,true,23.1);
        Pen somePen1 = new Pen(RED,MIDDLE,true,25.0);

        Workplace<? extends Stationery> workplace1 = new Workplace<>("Vasiliy Petrov");
        Workplace<? extends Stationery> workplace2 = new Workplace<>("Konstantin Perehodko");

        workplace1.addStationeryItem(someEraser);
        workplace1.addStationeryItem(somePen);
        workplace1.addStationeryItem(somePen1);

        workplace2.addStationeryItem(someEraser);
        workplace2.addStationeryItem(somePen);

        workplace1.countAll();
        workplace2.countAll();

        workplace1.printAllStationery();
        workplace2.printAllStationery();

    }
}