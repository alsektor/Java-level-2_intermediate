package team;
import iron_man.*;

/**
 * Write a description of class Sportsmen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Team1 extends Sportsmen implements Runable,Swimable,Bikeable {
    private int swim_limit;
    private int run_limit;
    private int bike_limit;
    private boolean neproshel;
    
    public Team1(String name) {
        this.name = name;
        this.run_limit = 50;
        swim_limit = 5;
        this.bike_limit = 190;
        this.neproshel=true;
    }
 
     @Override
     public boolean doIt (Sportsmen sportsmen){
         neproshel=false;
           return true;
     }

    @Override
    public boolean swim(int b) {
        return swim_limit >= b;
    }

    @Override
    public boolean run(int a) {
        return run_limit >= a;
    }
     @Override
    public boolean bike(int c) {
        return bike_limit >= c;
    }
       @Override
      public void info(){
        System.out.println(name+" result: " +run_limit+" "+swim_limit+" "+bike_limit);
    }
}
