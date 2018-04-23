package javase07.t02;

public class Checker {
    private ResourceProperty property;

    public Checker(String s) {
        try {
            property = new ResourceProperty(s);
            property.start();
            property.join();
        } catch (RuntimeException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        try {
            return property.getValue(key);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "";
    }
}