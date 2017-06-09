package iron_man;
import team.*;
/**
 * Write a description of class Water here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Maraphon {
    private int a;
    private int b;
    private int c;
    //private boolean neproshel;

    public Maraphon(int a,int b,int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        //this.neproshel=true;
    }

    public boolean doIt(Sportsmen sportsmen) {
        if (sportsmen instanceof Swimable)
            return ((Swimable) sportsmen).swim(b) ;
       if (sportsmen instanceof Runable)
            return ((Runable) sportsmen).run(a);
        if (sportsmen instanceof Bikeable)
            return ((Bikeable) sportsmen).bike(c); 
           //  neproshel=false;
       else
                 return false;
       
    }

}


