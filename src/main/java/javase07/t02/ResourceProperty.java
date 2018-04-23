package javase07.t02;

import java.util.HashMap;
import java.util.ResourceBundle;


public class ResourceProperty extends Thread {
    private ResourceBundle bundle;
    private HashMap<String, String> map = new HashMap<>();

    public ResourceProperty(String s) {
        bundle = ResourceBundle.getBundle(s);
    }


    @Override
    public void run() {
        for (String key : bundle.keySet()
                ) {
            map.put(key, bundle.getString(key));
        }
    }

    public  String getValue(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new RuntimeException("No key");
    }
}
