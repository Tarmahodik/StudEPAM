package javase02.t01;

import java.util.Objects;
import java.util.PrimitiveIterator;

public class Pen
{
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHandle() {
        return handle;
    }

    public void setHandle(boolean handle) {
        this.handle = handle;
    }

    private Color color;
    private Size size;
    private double price;
    private boolean handle;

    public Pen()
    {
        color = Color.BLUE;
        size = Size.BIG;
        price= 10.0;
        handle = true;
    }

    public Pen(Color color , Size size , Double price , Boolean handle)
    {
        this.price=price;
        this.color=color;
        this.size=size;
        this.handle=handle;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Double.compare(pen.price, price) == 0 &&
                handle == pen.handle &&
                color == pen.color &&
                size == pen.size;
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(color, size, price, handle);
    }


    @Override
    public String toString() {

        return String.format("%s@color=%s size=%s price=%f handle=%s",this.getClass().getName(),color.toString(),size.toString(),price,handle);
    }


}
