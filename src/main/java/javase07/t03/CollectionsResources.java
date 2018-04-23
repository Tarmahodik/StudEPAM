package javase07.t03;

import java.util.ArrayList;
import java.util.List;

public class CollectionsResources {
    private List<Integer> list;

    public CollectionsResources() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}