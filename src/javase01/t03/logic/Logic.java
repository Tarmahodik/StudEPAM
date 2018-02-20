package javase01.t03.logic;

import static java.lang.Math.tan;
import static java.lang.StrictMath.pow;

public class Logic
{
    private char stub ='|';

    public void count(double a, double b ,double h)
    {
        double ans_Double;
        String ans_Text;

        System.out.println("|-------------------------------------------------------------------------------------|");
        for( ; a<b ; a+=h)
        {

            ans_Double = tan(2*a)-3;
            ans_Text = String.format("%c x = %-20e%18c y = %-20e%18c",stub,a,stub,ans_Double,stub);
            System.out.println(ans_Text);

        }
        System.out.println("|-------------------------------------------------------------------------------------|");
    }


}
