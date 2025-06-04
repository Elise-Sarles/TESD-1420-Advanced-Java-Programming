package mypackage;
import java.util.Comparator;

public class Exercise20_21 {
	 public static void main(String[] args) {
		    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
		        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
		        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
		        new Circle(6.5), new Rectangle(4, 5)};

		    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
		      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
		      new Circle(3), new Circle(14), new Circle(12)};
		    
		    selectionSort(list, new GeometricObjectComparator());
		    for (int i = 0; i < list.length; i++)
		      System.out.println(list[i].getArea() + " ");
		  }
	 
	 public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		 for (int i = 0; i < list.length; i++){
			 int val = i;
			  
			  for (int j = i+1; j < list.length; j++)
	            {
	                if (comparator.compare(list[val], list[j]) > 0)
	                    val = j;
	            }
	            E temp = list[val];
	            list[val] = list[i];
	            list[i] = temp; 
		 }
	 }
}
