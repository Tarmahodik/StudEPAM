package javase05.t02;

import lombok.experimental.Accessors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropWorker
{
    private FileInputStream fileInputStream;
    private Properties properties;



    public void changePropFile(String propfilename)
    {
        try
        {
            fileInputStream = new FileInputStream(propfilename);
            Properties properties1 = new Properties();
            properties1.load(fileInputStream);
            properties = properties1;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.out.println("");
        }
        catch (IOException e)
        {
            System.out.println("Cannot load properties from this file");
        }

    }

    public String getPropValue(String propKey)
    {

        try
        {
            return (String) properties.get(propKey);

        }
        catch (Exception e)
        {
            System.out.println("Wrong propKey");
            return "";
        }
    }

    PropWorker (String propfilename)
    {
        try
        {
           properties = new Properties();
           fileInputStream = new FileInputStream(propfilename);
           properties.load(fileInputStream);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("Cannot load properties from this file");
        }


    }

}
