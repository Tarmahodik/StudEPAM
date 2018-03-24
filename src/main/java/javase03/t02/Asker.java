package javase03.t02;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

class Asker
{
    private Locale nowLocale;
    private Questions questions;
    private Scanner scanner = new Scanner(System.in);


     Asker()
    {
        nowLocale = new Locale("ru","RU");
        questions = new Questions(nowLocale);
        mainMenu();
    }

    private void mainMenu()
    {
        System.out.println(questions.getValue("allquestions"));
        System.out.println(questions.getValue("chooser"));
        try
        {
            switch (scanner.nextInt())
            {
                case 1: {
                    System.out.println(questions.getValue("answer1"));
                    mainMenu();
                }
                case 2: {
                    System.out.println(questions.getValue("answer2"));
                    mainMenu();
                }
                case 3: {
                    System.out.println(questions.getValue("answer3"));
                    mainMenu();
                }
                case 4: {

                    if (nowLocale.getCountry().equals("RU"))
                    {
                        nowLocale = new Locale("en","US");
                        questions.changeLocal(nowLocale);
                    }
                    else
                    {
                        nowLocale = new Locale("ru","RU");
                        questions.changeLocal(nowLocale);
                    }

                    mainMenu();
                }
                default: {
                    mainMenu();
                }
            }
        }
        catch (Exception e )
        {
            System.out.println("Error");
        }
    }



}
