package Test.oop;

public class Main
{
    public static void main(String[] args) {

        Lama lama = new Lama("main");
        LamaChanger lamaChanger = new LamaChanger(lama);

        System.out.println(lama.getName());
        System.out.println(lamaChanger.lamachangerlama.getName());


    }
}
