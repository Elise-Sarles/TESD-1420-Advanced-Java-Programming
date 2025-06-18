import java.util.Scanner;
/// O(n) time complexity
public class Exercise22_1 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String max = "";
        String sub = "";

        for (int i = 0; i < input.length(); i++) {
            if (sub.isEmpty() || input.charAt(i) > sub.charAt(sub.length() - 1)) {
                sub += input.charAt(i);
            } else {
                if (sub.length() > max.length()) {
                    max = sub;
                }
                sub = "" + input.charAt(i);
            }
        }
        if (sub.length() > max.length()) {
            max = sub;
        }

        System.out.println("Maximum Consecutive Substring is " + max);
    }
}