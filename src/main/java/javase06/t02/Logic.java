package javase06.t02;



//Создать “универсальный” класс, позволяющий получить значение
//        из любого properties- файла.
//Физическое чтение файла должно происходить только один раз.
//Результаты чтения храните в коллекции типа Map.
//Ответьте на вопрос:
//как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?



import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Logic
{
    Map<String,String> propfiles;
    PropLoader worker;

    public Logic()
    {
      propfiles = new HashMap<>();
      worker = new PropLoader();
    }

    public void addPropFile(String nameOfPropFile)
    {
        Properties prop  = worker.getPropertiesFromPropFile(nameOfPropFile);

        for (Object key : prop.stringPropertyNames())
        {
            propfiles.put(key.toString(),prop.getProperty(key.toString()));
        }

    }








}
