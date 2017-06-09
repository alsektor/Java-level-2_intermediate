import team.*;
import iron_man.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW21 {

    public static void main(String[] args) {
        Sportsmen[] Reebok = {new Team1("Ali"), new Team1("Izzy"), new Team1("Ozzy"), new Team1("Lemmy")};
        Sportsmen[] OCR = {new Team2("Tosha"), new Team2("Santer"), new Team2("Sid"), new Team2("Nency")};
        Maraphon maraphon = new Maraphon(21,4,180);
        
        for (Sportsmen sportsmen : Reebok) {
            maraphon.doIt(sportsmen);
            sportsmen.info();
            System.out.println(sportsmen+" result: " + maraphon.doIt(sportsmen));
             sportsmen.inform();
        }   
        for (Sportsmen sportsmen : OCR) {
            maraphon.doIt(sportsmen);
            System.out.println(sportsmen+" result: " + maraphon.doIt(sportsmen));
             sportsmen.info();   
              sportsmen.inform();
        }    
    }
}
