package javase01.t04.logic;


public class Logic
{

    public double findMax(double[] array)
    {
        int leftIndex = 0;
        int rightIndex = array.length-1;

        double max= Double.NEGATIVE_INFINITY;
        double result;

        while (leftIndex<rightIndex)
        {
            result = array[leftIndex]+array[rightIndex];
            if (result>max)
            {
                max = result;
            }
            leftIndex++;
            rightIndex--;
        }

        return max;

    }

    public double findMaxWithoutPointer(double[] array)
    {
        double max = Double.NEGATIVE_INFINITY;
        double result;

        if (array.length > 1)
        {
            for (int i = 0; i < array.length / 2; i++)
            {
                result = array[i] + array[array.length - 1 - i];
                if (result > max)
                {
                    max = result;
                }
            }
        }
        return max;

    }

}
