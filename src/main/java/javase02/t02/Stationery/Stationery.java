package javase02.t02.Stationery;

import org.jetbrains.annotations.NotNull;

public abstract class Stationery implements Comparable<Stationery> {
    private double price;
    private String name;

    @Override
    public int compareTo(@NotNull Stationery o)
    {
        return this.name.compareTo(o.getName());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stationery(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
}
