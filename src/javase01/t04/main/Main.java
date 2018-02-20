package javase01.t04.main;

import javase01.t04.logic.Logic;

public class Main
{

    public static void main(String[] args)
    {
        Logic l = new Logic();

        double[] array = {19.0,100.0,1.0};
        double res1;
        double res2;

        res1 = l.findMax(array);
        res2 = l.findMaxWithoutPointer(array);

        System.out.println(String.format("Результат первого метода : %f\nРезультат второго метода : %f",res1,res2));

    }
}
