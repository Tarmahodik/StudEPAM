package javase04.t03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader(new Getter().getFile("javase04/t03/input.txt"));
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        while ( br.ready() )
        {
            sb.append(br.readLine()).append("\n");
        }
        br.close();

        FileOutputStream fs = new FileOutputStream("output.txt");
        fs.write(sb.toString().getBytes("UTF-16"));
        fs.close();
    }
}