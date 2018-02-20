package javase01.t06.notepad;

public class Note
{
    private StringBuilder text;
    private int title;
    static private int uniqeNo;

    public String getText()
    {
        return text.toString();
    }


    public void editText(int start, int end, String text)
    {
        if (start > end || start < 0 || end >= this.text.length())
            return;
        this.text.delete(start, end);
        this.text.insert(start + 1, text);
    }


     Note()
    {
        title = uniqeNo;
        uniqeNo++;
        text = new StringBuilder();
    }

    Note(String text)
    {
        title = uniqeNo;
        uniqeNo++;
        this.text = new StringBuilder(text);
    }







}
