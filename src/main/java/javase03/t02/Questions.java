package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;

public class Questions
{
    private ResourceBundle bundle;




//    public void doSMTH(Locale locale)
//    {
//        String key = "question1";
//        System.out.println(bundle.getString(key));
//    }

    public String getValue(String key)
    {
        return bundle.getString(key);
    }

    public void changeLocal(Locale locale)
    {
        this.bundle = ResourceBundle.getBundle("questions",locale);
    }

    public Questions(Locale local)
    {
        this.bundle = ResourceBundle.getBundle("questions",local);
    }
}
