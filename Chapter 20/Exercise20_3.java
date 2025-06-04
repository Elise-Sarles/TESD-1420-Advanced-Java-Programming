package mypackage;
import java.util.*;
import java.util.Scanner;

public class Exercise20_3 {
	public static void main(String[] args) {
		
		 List<String> states = new ArrayList<>();
		List<String> capitals = new ArrayList<>();
		
	    String[][] stateCapital = {
	      {"Alabama", "Montgomery"},
	      {"Alaska", "Juneau"},
	      {"Arizona", "Phoenix"},
	      {"Arkansas", "Little Rock"},
	      {"California", "Sacramento"},
	      {"Colorado", "Denver"},
	      {"Connecticut", "Hartford"},
	      {"Delaware", "Dover"},
	      {"Florida", "Tallahassee"},
	      {"Georgia", "Atlanta"},
	      {"Hawaii", "Honolulu"},
	      {"Idaho", "Boise"},
	      {"Illinois", "Springfield"},
	      {"Indiana", "Indianapolis"},
	      {"Iowa", "Des Moines"},
	      {"Kansas", "Topeka"},
	      {"Kentucky", "Frankfort"},
	      {"Louisiana", "Baton Rouge"},
	      {"Maine", "Augusta"},
	      {"Maryland", "Annapolis"},
	      {"Massachusettes", "Boston"},
	      {"Michigan", "Lansing"},
	      {"Minnesota", "Saint Paul"},
	      {"Mississippi", "Jackson"},
	      {"Missouri", "Jefferson City"},
	      {"Montana", "Helena"},
	      {"Nebraska", "Lincoln"},
	      {"Nevada", "Carson City"},
	      {"New Hampshire", "Concord"},
	      {"New Jersey", "Trenton"},
	      {"New York", "Albany"},
	      {"New Mexico", "Santa Fe"},
	      {"North Carolina", "Raleigh"},
	      {"North Dakota", "Bismarck"},
	      {"Ohio", "Columbus"},
	      {"Oklahoma", "Oklahoma City"},
	      {"Oregon", "Salem"},
	      {"Pennsylvania", "Harrisburg"},
	      {"Rhode Island", "Providence"},
	      {"South Carolina", "Columbia"},
	      {"South Dakota", "Pierre"},
	      {"Tennessee", "Nashville"},
	      {"Texas", "Austin"},
	      {"Utah", "Salt Lake City"},
	      {"Vermont", "Montpelier"},
	      {"Virginia", "Richmond"},
	      {"Washington", "Olympia"},
	      {"West Virginia", "Charleston"},
	      {"Wisconsin", "Madison"},
	      {"Wyoming", "Cheyenne"}
	    };
	    
		for (int i = 0; i < stateCapital.length; i++) {
			states.add(stateCapital[i][0]);
			capitals.add(stateCapital[i][1]);
		}
	    
	    long seed = System.currentTimeMillis();
	    
		Collections.shuffle(states, new Random(seed));
		Collections.shuffle(capitals, new Random(seed));

	    Scanner input = new Scanner(System.in);
	    
	    int correctCount = 0;
	    
	    for (int i = 0; i < states.size(); i++) {
			System.out.print("What is the capital of "
				+ states.get(i) + "? ");
			String capital = input.nextLine();

			if (isEqual(capitals.get(i), capital)) {
				System.out.println("Your answer is correct");
				correctCount++;
			}
			else {
				System.out.println("The correct answer should be " + 
					capitals.get(i));
			}
		}
	    System.out.println("The correct count is " + correctCount);
	  }
	
	static boolean isEqual(String n, String o) {
		//// making capitalization not matter. 
		String c = n.toLowerCase();
		String a = o.toLowerCase();
		
		if (c.length() != a.length())
			return false;

		for (int i = 0; i < c.length(); i++) {
			if (c.charAt(i) != a.charAt(i))
				return false;
		}

		return true;
		
	}
}

