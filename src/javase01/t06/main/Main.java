package javase01.t06.main;

import javase01.t06.notepad.Notepad;

public class Main
{
    public static void main(String[] args)
    {
        Notepad notepad = new Notepad();
        notepad.addNote("sometext");
        System.out.println(notepad.getNode(0));

    }
}
