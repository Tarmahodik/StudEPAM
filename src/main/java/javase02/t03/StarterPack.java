package javase02.t03;

import javase02.t02.Stationery.Eraser;
import javase02.t02.Stationery.Pen;
import javase02.t02.Stationery.Puncher;

public class StarterPack
{
    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        if(pen!=null)
        {
            this.pen = pen;
        }
    }

    public Eraser getEraser() {
        return eraser;
    }

    public void setEraser(Eraser eraser) {
        if(eraser!=null)
        {
            this.eraser = eraser;
        }
    }

    public Puncher getPuncher() {
        return puncher;
    }

    public void setPuncher(Puncher puncher) {
        if(puncher!=null)
        {
            this.puncher = puncher;
        }
    }

    private Puncher puncher;
    private Pen pen;
    private Eraser eraser;



}
