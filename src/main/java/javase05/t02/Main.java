package javase05.t02;

import java.io.*;
import java.util.Properties;

public class Main
{

    public static void main(String[] args)
    {
      PropWorker worker = new PropWorker("test.properties");
      String result = worker.getPropValue("test");
      System.out.println(result);

      worker.changePropFile("test12.properties");
      result = worker.getPropValue("test");
      System.out.println(result);
    }

}
