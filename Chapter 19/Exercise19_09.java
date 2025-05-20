package mypackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise19_09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many random number do you want you in your list? (Enter an Integer)");
		int length = input.nextInt();
		
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < length; i++) {
	    	 list.add((int)(Math.random() * 20));
	    }
	    
	    sort(list);
	    System.out.println(list);
	    reversesort(list);
	    System.out.println(list);
	   
	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for (int i = 0; i < list.size() - 1; i++) {
		    E currentval = list.get(i);
		    int Index = i;

		    for (int k = i + 1; k < list.size(); k++) {
		      if (currentval.compareTo(list.get(k)) > 0) {
		        currentval = list.get(k);
		        Index = k;
		      }
		    }

		    if (Index != i) {
		      list.set(Index, list.get(i));
		      list.set(i, currentval);
		    }
		  }
	}

	public static <E extends Comparable<E>> void reversesort(ArrayList<E> list) {
		for (int i = 0; i < list.size() - 1; i++) {
		    E currentval = list.get(i);
		    int Index = i;
	
		    for (int k = i + 1; k < list.size(); k++) {
		      if (currentval.compareTo(list.get(k)) < 0) {
		        currentval = list.get(k);
		        Index = k;
		      }
		    }
	
		    if (Index != i) {
		      list.set(Index, list.get(i));
		      list.set(i, currentval);
		    }
		  }
	}
}

