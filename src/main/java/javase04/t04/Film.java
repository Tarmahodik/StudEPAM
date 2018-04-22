package javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Film implements Serializable
{
    private static final long serialVersionUID = 1575079368928155524L;
    private String name;
    private List<Actor> actors;

    public Film(String name, List<Actor> actors) {
        this.name = name;
        this.actors = actors;
    }

    public Film(String name) {
        actors = new ArrayList<>();
        this.name = name;
    }

    public void addActor(Actor a) {
        this.actors.add(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }
}

