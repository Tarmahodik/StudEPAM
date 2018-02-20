package javase01.t06.notepad;

import java.util.ArrayList;
import java.util.List;

public class Notepad
{
    private List<Note> notes;


    public String getNode(int id)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        return notes.get(id).getText();
    }

    public void addNote(String text)
    {
        notes.add(new Note(text));

    }
    public void deleteNote(int id)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        notes.remove(id);
    }

    public void editNote(int id, int start, int end, String text)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        notes.get(id).editText(start, end, text);
    }


    public Notepad()
    {
        notes = new ArrayList<>();
    }

}
