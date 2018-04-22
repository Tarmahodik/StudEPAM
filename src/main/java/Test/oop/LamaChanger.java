package Test.oop;

public class LamaChanger
{

    Lama lamachangerlama;


    public LamaChanger(Lama lama)
    {
        this.lamachangerlama = lama;
        changename();
    }

    private void changename()
    {
        this.lamachangerlama.setName("nemain");
    }



}
