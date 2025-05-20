package mypackage;

import java.util.Scanner;

public class Exercise19_05 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many random number do you want you in your list? (Enter an Integer)");
		int length = input.nextInt();
		
		Integer[] list = new Integer[length];
		 for (int i = 0; i < list.length; i++) {
	            list[i] = (int)(Math.random() * 20);
	            System.out.print(list[i] + ", ");
		 }
		 System.out.println(" ");
		 
		 System.out.println("Max number in the list is: " + max(list));
		 

	}
	public static <E extends Comparable<E>> E max(E[] list) {
		
		E max = list[0];
		for(int i = 1; i <= (list.length -1); i++) {
            E option = list[i];
            if (option.compareTo(max) > 0) {
                max = option;
            }
		}
		
		return max;
	}
}
