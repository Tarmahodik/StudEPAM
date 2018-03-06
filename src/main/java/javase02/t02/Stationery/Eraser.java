package javase02.t02.Stationery;

import javase02.t01.Size;
import javase02.t01.Color;

public class Eraser extends Stationery
{
    private Size size;

    @Override
    public String toString()
    {
        return String.format("\nPen\n{\n size = %s\n" +
                " price = %f\n name = %s\n}",size,super.getPrice(),super.getName());
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }



    public Eraser(String name,Size size,double price)
    {
        super(name,price);
        this.size = size;
    }
}
