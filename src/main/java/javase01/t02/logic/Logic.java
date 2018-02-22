package javase01.t02.logic;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Logic
{
    public void findMin(int n , double e)
    {
        for(int i = 0 ; i<n;i++)
        {

            double ans = 1/pow(i+1,2);


            if(ans<e)
            {
                System.out.println(i);
                break;
            }
            else
            {
                System.out.println(ans);
            }
        }


    }
}
