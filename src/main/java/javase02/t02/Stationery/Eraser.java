package javase02.t02.Stationery;

import javase02.t01.Size;
import javase02.t01.Color;

public class Eraser extends Stationery
{
    private Size size;
    private Color color;

    @Override
    public String toString()
    {
        return String.format("\nPen\n{\n color = %s\n size = %s\n" +
                " price = %f\n}",color,size,super.getPrice());
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

    public Eraser(Size size, Color color,double price)
    {
        super(price);
        this.size = size;
        this.color = color;

    }
}
