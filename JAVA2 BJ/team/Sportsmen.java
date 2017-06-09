package team;
import iron_man.*;


/**
 * Abstract class Team - write a description of the class here
 *
 * @Al-Vasiti Ali author (your name here)
 * @version (version number or date here)
 */
public abstract class Sportsmen  {
    protected String name;
    protected int run_limit;
    protected int swim_limit;
    protected int bike_limit;
    protected boolean neproshel;

     
 
    public boolean run(int a) {
        return run_limit >= a;
    }
      public boolean swim(int b) {
        return swim_limit >= b;
    }
      public boolean bike(int c) {
        return bike_limit >= c;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + " " + name+" ";
    }
               public void inform() {
                    String isNeproshli = (neproshel) ? "neproshel" : "proshel";
                    System.out.println(name + ": " + isNeproshli);
               }
              public boolean doIt (Sportsmen sportsmen){
                  neproshel=false;
                  return true;
             }
                
    public void info(){
        System.out.println(name+" result: " +run_limit+" "+swim_limit+" "+bike_limit);
    }
}
