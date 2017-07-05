/**
 * Java. Level 2. Lesson 2
 *
 * @author Ali Al-Vasiti
 * @version dated Juni 14,2017
 */
/*
     * 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся): +
				а. Посчитать сколько раз встречается каждое слово; +
				б. Найти список слов, из которых состоит текст (дубликаты не считать);+

     * 2.  Написать простой класс ТелефонныйСправочник:
			а. В каждой записи всего три поля: Фамилия, Телефон, email;
			б. Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили телефон), 
			и отдельный метод для поиска email по фамилии. Следует учесть, что под одной фамилией может быть несколько записей.
			Желательно как можно меньше добавлять своего, чего нет в задании
			(т.е. не надо в телефонную запись добавлять ещё дополнительные поля (имя, отчество, адрес), 
			делать взаимодействие с пользователем через консоль и т.д.).

     */
import java.util.*;

public class HW23{
		public static void main(String[] args) {
		   	String text = "Who doesnt love music Whatever mood we have  bad or good from time to time we turn on our favorite song And it in turn either calms us or on the contrary makes us fall into melancholy Life without music would be boring and dull Just imagine a disco being in silence or holidays being without musicians Absolutely all people of every type around the world are not indifferent to the music Genres that are most popular are rock rap pop techno chanson hip hop and others There are other very specific genres For example folk music classical music, spiritual music and also such interesting genres as blues and jazz Have you ever noticed that people who share your tastes in music get along with you much faster than those whose tastes are very different from yours Many people believe that music is first and foremost an instrument of the soul Probably it is so Most of all I like modern music but I also will not refuse to listen to classical and ethnic music For example I like Spanish folk songs Listening to foreign songs I improve my knowledge of English This is a great way to mix business with pleasure";
       	 	StringBuilder temp=new StringBuilder();
            Map<String, Integer> tm = new TreeMap<>();
        	tm.put("love", 1);
        	tm.put("music", 2);
        	tm.put("bad", 1);
       		tm.put("good", 2);
       		tm.put("time", 1);
       		tm.put("song", 1);
       		tm.put("melancholy", 1);
       		tm.put("Life", 1);
       		tm.put("music", 2);
       		tm.put("good", 2);
       		tm.put("world", 1);
        	tm.put("rock", 3);
        	tm.put("rock", 3);
       		tm.put("rap", 1);
       		tm.put("rock", 3);
       		tm.put("pop", 1);
       		tm.put("techno", 1);
       		tm.put("blues", 1);
       		tm.put("jazz", 1);
       		tm.put("Spanish", 1);
        	Set<Map.Entry<String, Integer>> set = tm.entrySet();
        	System.out.println("Kazdoe slovo vsrtechaetsya v massive:"+tm);
      
        	for(Map.Entry<String, Integer> o : set){
       			String key = o.getKey();
      		  	Integer value = o.getValue();
      	     	temp.append(key).append(", ");
    		}
        
		   	String result=temp.toString();
		   	String[] slova = text.split(" ");
        	String[] words = result.split(",");
          
             for(int i = 0; i<slova.length; i++){
          	  	try{
           		if(slova[i] == words[i])
           			slova[i] = words[i];
           	 System.out.println("Slovo iz pervonachalnogo massiva,kot vstrechayutsya v tekste:"+words[i]);
           		 } catch(ArrayIndexOutOfBoundsException ex) { }	 	
          	}
       			
			System.out.println("");

			PhoneBook ts = new PhoneBook();
		     ts.poehali();
        
		}
	
	
        public static class PhoneBook {
        	private LinkedHashMap<String, Telefon> ts;
               	Scanner sc = new Scanner(System.in);

        	public PhoneBook() {

       	 		ts = new LinkedHashMap<String, Telefon>();
       	 		ts.put("seroshtan", new Telefon("9032546478", "seroshtan@mail.com"));
       	 		ts.put("sviridov", new Telefon("9154784579", "sviridov@mail.com"));
				ts.put("stepanov", new Telefon("9254754784", "stepanov@mail.com"));
				ts.put("popov", new Telefon("9160461074", "popov@mail.com"));
				//ts.put("popov", new Telefon("9055233454", "popov2@mail.com"));
				ts.put("zeinalov", new Telefon("9032478741", "zeinalov@mail.com"));

       	 	} 
			public void poehali() {
				int a=0;
				int b=0;
				do
				{
            		System.out.print("Vvedite Familiyu, Poluchite telefon: ");
       	 			System.out.println(getTelefonPoImeni(sc.next()));
       	 			System.out.print("Esli hotite prodolzhit smotret telefon po famillii,nazmite 0, esli hotite smotret e-mail,nazmite 1: ");
       	 			a = sc.nextInt();
       	 		}
            	while (a==0);
            	do
            	{
            		System.out.print("Vvedite Familiyu,poluchite milo: ");
            		System.out.println(getMiloPoImeni(sc.next()));
            		System.out.print("Esli hotite prodolzhit smotret e-mail po famillii,nazmite 0, esli hotite viiti,nazmite 1: ");
       	 			b = sc.nextInt();
            	}
            	while (b==0);
            
            }
			public String getTelefonPoImeni (String name) {          	
            	
            		try {
			//Set<Map.Entry<String, Telefon>> set = ts.entrySet();
			//for(LinkedHashMap<String, Telefon> o : set) 
                Telefon o = ts.get(name);
                	return o.getTelefon();
		        	   } catch(NullPointerException e) { 
               		return "Ne Naideno.";
            		}
           	}
        	public String getMiloPoImeni(String name) {
         	  	 try {
                Telefon o = ts.get(name);
                return o.getMilo();
                } catch(NullPointerException e) { 
                return "Ne Naideno.";
                }
        	}
       	 		
        }
       		public static class Telefon {
        		public String telefon;
        		public String milo;

        		public Telefon (String t, String m) {
        			telefon = t;
        			milo = m;
        		}
				public String getTelefon() {
         	   			return telefon;

       			}

        		public String getMilo() {
        		 	return milo;
       			}
      		}
      	
}