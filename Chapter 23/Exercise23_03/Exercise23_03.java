/*
Author: 
Date: 

Description: 
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
public static <E extends Comparable<E>> void quickSort(E[] list){
  if (list.length <= 1) {
    return; // Base case: array is already sorted
  }
  for (int i = 0; i < list.length - 1; i++) {
    for (int j = i + 1; j < list.length; j++) {
      if (list[i].compareTo(list[j]) > 0) {
        // Swap list[i] and list[j]
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
      }
    }
  }

}

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator){
    if (list.length <= 1) {
      return; // Base case: array is already sorted

    }
    for (int i = 0; i < list.length - 1; i++) {
      for (int j = i + 1; j < list.length; j++) {
        if (comparator.compare(list[i], list[j]) > 0) {
          // Swap list[i] and list[j]
          E temp = list[i];
          list[i] = list[j];
          list[j] = temp;
        }
      }
    }

  }
}
