/**
 * Java. 2-5
 *
 * @author Ali Al-Vasiti
 * @version 0.1 dated Jun 21, 2017
 * 1. 1.	Необходимо написать два метода, которые делают следующее:
 * a.	Создают одномерный длинный массив, например: 
 * b.	static final int size = 10000000;
 * c.	static final int h = size / 2;
 * d.	float[] arr = new float[size];
 * e.	Заполняют этот массив единицами;
 * f.	Засекают время выполнения: long a = System.currentTimeMillis();
 * g.	Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * h.	Проверяется время окончания метода System.currentTimeMillis();
 * i.	В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *
 * Чем отличается первый метод от второго:
 * Первый бежит по массиву и высчитывает значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения, и потом склеивает эти массивы обратно в один.
 *
 */
class HW25 {

    public static void main(String args[]) {
    	MyThread mt1 = new MyThread("method 2");
   	    	final int size = 10000000;
		    final int h = size / 2;
			float[] arr = new float[size];
			for (int i = 0; i < arr.length; i++) {
		    	arr[i]=1;
		    }	
		    long a = System.currentTimeMillis();
		    for (int i = 0; i < arr.length; i++) { 
		    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		    }	
		    
		    System.out.println("method 1: "+(System.currentTimeMillis() - a));
    }
}

class MyThread extends Thread {	
	final int size = 10000000;
	final int h = size / 2;
	float[] arr = new float[size];
  	float [] a1= new float[h];
	float [] a2= new float[h];

	MyThread(String name) {
        super(name);
        start();
    }
    // starting new thread
   public void run() {
   		System.arraycopy(arr, 0, a1, 0, h);
        	for (int i = 0; i < a1.length; i++) {
        		a1[i]=1;
        	}
    	System.arraycopy(arr, 0, a2, 0, h);
        	for (int i = 0; i < a2.length; i++) {
        		a1[i]=1;
        	}
        long a = System.currentTimeMillis();
        for (int i = 0; i < a1.length; i++) { 
		  a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
		for (int i = 0; i < a2.length; i++) { 
		  a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
		System.arraycopy(a1, 0, arr, 0, h);
		System.arraycopy(a2, 0, arr, h,h);
		System.out.println("method 2: "+(System.currentTimeMillis() - a));
    }
}
/* что касается дополнительного задания, с включенной синхронизацией цикл отрабатывается последовательно, сначала дитя 1 проходится по нему
* и суммирует 1+2+3+4+5, второе дитя ждёт, а потом проделывает тоже самое, в итоге у обоих получается значение 15. Без синхронизации у меня
* на компе тоже одинаковые значения, при разных запусках это,либо 18, либо 29. Так получается, потому что они хаотично крутят счётчик
* При первом проходе 1-1, при втором 3-3, а вот на третьем 6-9, т.е. второй поток вырывается вперед,пока спит первый, а на четвертом (13-13)
* и пятом (18-18) проходе они выравниваются. Получается, при синхронизации, каждый поток начинает по очереди крутить переменную sum c нуля.
* При этом, мы выходим на запланированное значение. А без синхронизации, потоки хаотично обращаются к sum и результат получатся
* непредсказуемым... Надеюсь, я правильно всё понял...
*/