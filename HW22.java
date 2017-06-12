/**
 * Java. Level 2. Lesson 2
 *
 * @author Ali Al-Vasiti
 * @version dated Juni 11,2017
 */
/*
     * 1. 1.	Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)
		1 3 1 2
		2 3 2 2
		5 6 7 1
		3 3 1 0

		Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][]; +
     * 2.  Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат; +
     * 3.  Ваш метод должен бросить исключения в случаях:
     		○	Если размер матрицы, полученной из строки, не равен 4x4;
			○	Если в одной из ячеек полученной матрицы не число; (например символ или слово)
	 * 4. В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.
     */

public class HW22{
	public static void main(String[] args) {
		
		String name="1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 5 0";
		try {
			Method(name);
		} 	catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
 			}
	}
	public static void Method(String name) throws ArrayIndexOutOfBoundsException  {
		
		String[] oneDimArr = name.split("\n");
        String[][] twoDimArr = {
                oneDimArr[0].split(" "),
                oneDimArr[1].split(" "),
                oneDimArr[2].split(" "),
                oneDimArr[3].split(" "),
        };       
	 int[][] myIntArray = new int[4][4];
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
               try {
                	myIntArray[i][j] = Integer.parseInt(twoDimArr[i][j]);
                	 throw new ArrayIndexOutOfBoundsException("Razmer matrici ne raven 4x4");
                } catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println(ex);
				  }
            }
        }
        int result=0;
        for (int[] ants : myIntArray) {
        	for (int anInt : ants) 
        	result=(result+anInt);
        }
        result=result/2;
        System.out.print(+result);
        System.out.println();
        //выводим массив на консоль
        for (int[] ints : myIntArray) {
            for (int anInt : ints) {
               System.out.print(anInt + " ");
            }
            System.out.println();
        }
    
		//abc=ccc;
		//String ccc = new String [][];  
		//for (int i = 0; i < 4; i++) {      
 		//for (int j = 0; j < 4; j++) {

	}

}