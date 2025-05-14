/* 
Title: Exercise18_9
Description: Reverses a string using recursion.
Author: Elise Sarles
Date: May 9 2025
*/
import java.util.Scanner;
public class Exercise18_9{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string of letters or characters: ");
        String str = input.nextLine();
        System.out.print("The reverse of the string is: ");
        reverseDisplay(str);
        input.close();
        System.out.println(); // Print a new line after the reversed string
    }
    public static void reverseDisplay(String str){
        if (str.length() == 0){
            return;
        }
        System.out.print(str.charAt(str.length() - 1));
        reverseDisplay(str.substring(0, str.length() - 1));
    }
}