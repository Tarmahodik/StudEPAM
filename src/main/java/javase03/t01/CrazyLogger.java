package javase03.t01;

import java.text.SimpleDateFormat;
import java.util.Date;


//Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как накопитель объект типа StringBuilder.
//Логгер должен содержать методы поиска определенной информации в таком логе
//[с возможностью вывода ее в поток ввода вывода].
//Информацию логгер хранит в форматированном виде:
//
// dd-mm-YYYY : hh-mm – message

public class CrazyLogger
{
    private StringBuilder log;
    private SimpleDateFormat dateFormater;


    CrazyLogger()
    {
        log = new StringBuilder();
        dateFormater = new SimpleDateFormat("dd-MM-yyyy : hh-mm '-' ") ;
    }

    public Date addToLog(String text)
    {
        Date ddd = new Date();
        log.append(dateFormater.format(ddd)).append(text).append("\n");
        return ddd;
    }


    //доделать
    public void printLog()
    {
        System.out.println(log);
    }


    //Можно добавить
    private String findUniversal(Object obj)
    {
        String[] logMass = log.toString().split("\n");
        String findText = "";
        StringBuilder result = new StringBuilder();

        if(obj instanceof String)
        {
            findText = obj.toString();
        }
        else if (obj instanceof Date)
        {
            findText = dateFormater.format((Date)obj);
        }

        result.append("Find : \"").append(findText).append("\"\n");

        for(String s : logMass)
        {
            if(s.contains(findText))
            {
                result.append(s).append("\n");
            }
        }

        result.append("RESULT");
        return result.toString();

    }

    public String findInfoByString(String findText)
    {
        return this.findUniversal(findText);
    }

    public String findInfoBtDate(Date date)
    {
        return this.findUniversal(date);
    }

}
