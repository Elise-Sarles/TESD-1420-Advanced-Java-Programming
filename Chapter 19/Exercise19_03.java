package mypackage;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise19_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many random number do you want you in your list? (Enter an Integer greater then 3)");
		int length = input.nextInt();
		
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    for (int i = 0; i < length - 2; i++) {
	    	 list.add((int)(Math.random() * 20));
	    }
	    /// Making sure there is a duplicate to be removed. 
	    list.add(14);
	    list.add(14);

	    
	    System.out.println("Orginal list: " + list);
	    
	    ArrayList<Integer> newlist = removeDuplicates(list);
	    
	    System.out.println("List after duplicates are moved: " + newlist);
	   
	}
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> newlist = new ArrayList<E>(list.size());
		
		for(int i = 0; i < list.size() - 1; i++){
			if (!newlist.contains(list.get(i))) {
                newlist.add(list.get(i));
			}
		}
		
		
		
		return newlist;
	}
}
