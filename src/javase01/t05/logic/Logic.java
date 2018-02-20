package javase01.t05.logic;

public class Logic
{
    public void drawMatrix(int size) {


        int[][] matrix = new int[size][size];
        matrix[size / 2][size / 2] = 1;


        for (int i = 0; i < size / 2; i++)
        {
            matrix[i][i] = 1;
            matrix[size - i - 1][size - i - 1] = 1;
            matrix[size - i - 1][i] = 1;
            matrix[i][size - i - 1] = 1;
        }


        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                str.append(String.format("%d ", matrix[j][i]));
            }
            str.delete(str.length()-1,str.length());
            str.append('\n');
        }
        System.out.println(str);
    }


}
