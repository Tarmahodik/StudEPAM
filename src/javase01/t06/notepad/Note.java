package javase01.t06.notepad;

public class Note
{


    private StringBuilder text;
    private StringBuilder title;


    /**
     * Возвращает текст записи
     *
     * @return возвращает текст записи
     */
    public String getText()
    {
        return text.toString();
    }

    /**
     * Возвращает заголовок записи
     *
     * @return возвращает заголовок записи
     */
    public String getTitle()
    {
        return title.toString();
    }

    /**
     * Меняет заголовок записи на указанном промежутке
     *
     * @param start индекс начала замены
     * @param end индекс конца замены
     * @param title заголовок замены
     */
    public void editTitle(int start, int end, String title)
    {
        if (start > end || start < 0 || end >= this.title.length())
            return;
        this.text.delete(start, end);
        this.text.insert(start + 1, title);
    }

    /**
     * Меняет заголовок записи на указанном промежутке
     *
     * @param start индекс начала замены
     * @param end индекс конца замены
     * @param text текст замены
     */
    public void editText(int start, int end, String text)
    {
        if (start > end || start < 0 || end >= this.text.length())
            return;
        this.text.delete(start, end);
        this.text.insert(start + 1, text);
    }


    Note()
    {
       this.text = new StringBuilder();
       this.title = new StringBuilder();
    }

    Note(String text)
    {
        this.text = new StringBuilder(text);
        this.title = new StringBuilder();
    }

    Note(String title ,String text)
    {
        this.text = new StringBuilder(text);
        this.title = new StringBuilder(title);
    }







}
