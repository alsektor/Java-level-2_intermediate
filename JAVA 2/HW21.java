/**
 * Java. Level 2. Lesson 1
 *
 * @author Ali Al-Vasiti
 * @version dated Juni 05,2017
 */
/*
     * 1. Разобраться с имеющимся кодом; +
     * 2. Добавить класс Команда, который будет содержать: название команды, массив из 4-х 
     * участников (т.е. в конструкторе можно сразу указывать всех участников), метод для вывода 
     * информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
     * 3.Добавить класс ПолосаПрепятствий, в котором будут находиться: массив препятствий, метод,
     *  который будет просить команду пройти всю полосу;
     */
public class HW21{
	public static void main(String[] args) {
          IronMan c =new IronMan (21,180,4); // Создаем полосу препятствий 
          Team [] t1=new Team [4]; //создаём первую команду
          t1[0] = new Team("Reebok","Kartsev Nikita",0,0,0); 
          t1[1] = new Team("Reebok","Makarov Vadim",0,0,0);
          t1[2] = new Team("Reebok","Seroshtan Dmitriy",0,0,0);
          t1[3] = new Team("Reebok","Sviridov Dmitriy",0,0,0);
          Team [] t2=new Team [4]; //создаём вторую команду
          t2[0] = new Team("OCR","Petrov Anton",0,0,0); 
          t2[1] = new Team("OCR","Murashev Michail",0,0,0);
          t2[2] = new Team("OCR","Pivtorak Alexey",0,0,0);
          t2[3] = new Team("OCR","Vidra Yulia",0,0,0);
          for (Team t: t1) {
            t.info();
            t.inform();
            c.maraphon(t);
            t.info();
            t.inform(); 
          }
           for (Team t: t2) {
            t.info();
            t.inform();
            c.maraphon(t);
            t.info();
            t.inform(); 
          } 
     } 
}

     class IronMan {
          private int run; 
          private int bike; 
          private int swim; 
          public IronMan (int run, int bike,int swim) {
               this.run = run;
               this.bike = bike; 
               this.swim = swim;  
          }  
             public void maraphon (Team t) {
                       t.increaseRun(run);
                       t.increaseBike(bike);
                       t.increaseSwim(swim); 
                    
            }
     }
     
     class Team {
          private String teamname;
          private String name;
          private boolean neproshli;
          private int run; 
          private int bike; 
          private int swim; 
          public Team(String teamname,String name,int run, int bike,int swim) {
              this.teamname=teamname;
              this.name=name;
              this.neproshli = true;
              this.run = run;
               this.bike = bike; 
               this.swim = swim;
          }
                void inform() {
                    String isNeproshli = (neproshli) ? "neproshel" : "proshel";
                    System.out.println(name + ": " + isNeproshli);
               }
               public void info(){
                    System.out.println(teamname+" "+name+" "+"result:"+run+" "+swim+" "+bike);    
               }
                boolean increaseRun(int n) {
                    run+=n;    
                    return true;
               } 
               boolean increaseSwim(int g) {
                    swim+=g;
                    neproshli=false;
                    return true;
               }
               boolean increaseBike(int f) {
                    bike+=f;
                    return true;
               }
     }     
