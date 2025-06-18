import java.util.Scanner;
///  time complexity O(n)
public class Exercise22_3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        System.out.print("Enter a second string: ");
        String str2 = input.nextLine();

        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str2.charAt(length)) {
                length++;
            }else {
                length = 0; 
            }
            if (length == str2.length()) {
                System.out.println("Mached at index " + (i - length + 1));
                return;
            }
        }
        
    }

}