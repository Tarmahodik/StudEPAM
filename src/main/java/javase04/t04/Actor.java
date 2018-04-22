package javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Actor implements Serializable
{
    private static final long serialVersionUID = 1188107752617922442L;
    private String name;
    private List<Film> films = new ArrayList<>();

    public Actor(String name, List<Film> films) {
        this.name = name;
        this.films = films;
    }

    public Actor(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public String getName() {
        return name;
    }
}