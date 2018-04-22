package javase06.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropLoader
{
    private FileInputStream fileInputStream;
    private Properties properties;



    public Properties getPropertiesFromPropFile(String nameOfPropFile)
    {
        properties = new Properties();
        try
        {
            fileInputStream = new FileInputStream(nameOfPropFile);
            properties.load(fileInputStream);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e )
        {
            e.printStackTrace();
        }
        return properties;
    }
}
