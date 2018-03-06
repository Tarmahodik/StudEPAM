package javase02.t02.Stationery;

import javase02.t01.Color;
import javase02.t01.Size;

public class Puncher extends Stationery
{

    @Override
    public String toString()
    {
        return String.format("\nPuncher\n{\n size = %s\n" +
                " price = %f\n name = %s\n color = %s\n}",size,super.getPrice(),super.getName(),color.toString());
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color;
    private Size size;

    public Puncher(String name,double price,Color color,Size size)
    {
        super(name,price);
        this.size = size;
        this.color= color;
    }
}
