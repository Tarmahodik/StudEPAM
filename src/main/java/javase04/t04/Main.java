package javase04.t04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        System.out.print("Введите название файла: ");
        Scanner in = new Scanner(System.in);

        File input = new File(in.nextLine());
        FileInputStream fis = new FileInputStream(input);

        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Film> inputFilms = new ArrayList<>();
        while (ois.available() != 0)
        {
            inputFilms.add((Film) ois.readObject());

        }
        System.out.println();



        modify(inputFilms);


        FileOutputStream fos = new FileOutputStream(input);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        inputFilms.forEach(x ->
        {
            try
            {
                oos.writeObject(x);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });

    }

    private static void modify(List<Film> inputFilms)
    {
        System.out.println("В какой объект хотите внести правки? Введите индекс (начиная с 0):");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        Film film = inputFilms.get(index);
        System.out.println("Какие правки хотите внести? 1 - изменить название фильма; 2 - добавить актера.");
        in = new Scanner(System.in);
        int i = in.nextInt();
        if (i == 1) {
            System.out.println("Введите новое название фильма:");
            in = new Scanner(System.in);
            String s = in.nextLine();
            film.setName(s);

        } else {
            System.out.println("Введите имя актера:");
            in = new Scanner(System.in);
            String s = in.nextLine();
            Actor actor = new Actor(s);
            actor.addFilm(film);
            film.addActor(actor);
        }
        System.out.println("Готово. Еще что-нибудь? y/n");
        in = new Scanner(System.in);
        if (in.nextLine().equals("y")) modify(inputFilms);

    }
}

