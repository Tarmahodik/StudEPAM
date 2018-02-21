package javase01.t06.notepad;

import java.util.ArrayList;
import java.util.List;

public class Notepad
{
    private List<Note> notes;


    /**
     * Получить запись с выбранным id
     * @param id - id записи
     * @return текст записи
     */
    public String getNodeText(int id)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        return notes.get(id).getText();
    }

    /**
     * Получить запись с выбранным id
     * @param id - id записи
     * @return заголовок записи
     */
    public String getNodeTitle(int id)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        return notes.get(id).getTitle();
    }

    /**
     * Добавить новую запись
     * 
     */
    public void addNote()
    {
        notes.add(new Note());

    }

    /**
     * Добавить новую запись
     * @param text - текст записи
     */
    public void addNote(String text)
    {
        notes.add(new Note(text));

    }

    /**
     * Добавить новую запись
     * @param text - текст записи
     * @param title - заголовок записи
     */
    public void addNote(String text,String title)
    {
        notes.add(new Note(title,text));

    }

    /**
     * Удалить запись по id
     * @param id - id записи
     */
    public void deleteNote(int id)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        notes.remove(id);
    }

    /**
     * Изменить текст записи
     * @param id индекс записи
     * @param start индекс начала изменяемой записи
     * @param end индекс конца изменяемой записи
     * @param text новый текст
     */
    public void editNote(int id, int start, int end, String text)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        notes.get(id).editText(start, end, text);
    }


    /**
     * Изменить заголовок записи
     * @param id индекс записи
     * @param start индекс начала изменяемой записи
     * @param end индекс конца изменяемой записи
     * @param title новый текст
     */
    public void editTitle(int id, int start, int end, String title)
    {
        assert id > 0 && id < notes.size() : String.format("Wrong id, %d",id);
        notes.get(id).editTitle(start, end, title);
    }


    public Notepad()
    {
        notes = new ArrayList<>();
    }

}
