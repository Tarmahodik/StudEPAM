package javase02.t02.Stationery;

import javase02.t01.Color;
import javase02.t01.Size;

public class Pen extends Stationery
{
    private Color color;
    private Size size;
    private Boolean handle;

    @Override
    public String toString() {
        return String.format("\nPen\n{\n color = %s\n size = %s\n handle = %s\n " +
                "price = %f\n name = %s\n}",color,size,handle,super.getPrice(),super.getName());
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Boolean getHandle() {
        return handle;
    }

    public void setHandle(Boolean handle) {
        this.handle = handle;
    }

    public Pen(String name,Color color, Size size, Boolean handle,double price)
    {
        super(name,price);
        this.color = color;
        this.size = size;
        this.handle = handle;
    }




}
