package javase02.t02.Stationery;

public abstract class Stationery
{
    private double price;

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }



    public Stationery(double price)
    {
        this.price = price;
    }
}
