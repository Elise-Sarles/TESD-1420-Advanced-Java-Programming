/* 
Title: GCD.java
Description: Finds the GCD (Greatest Common Divisor) of two integers using recursion.
Author: Elise Sarles
Date: May 9 2025

*/ 
import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int m = input.nextInt();
        int n = input.nextInt();
        // Check for negative integers and zero
        input.close();
        if (m < 0 || n < 0) {
            System.out.println("Please enter positive integers.");
            System.exit(0);
        }
        if (m == 0 && n == 0) {
            System.out.println("GCD is undefined for both numbers being zero.");
            System.exit(1);
        }
        
        int gcd = findGCD(m, n);
        System.out.println("The GCD of " + m + " and " + n + " is: " + gcd);
    }

    public static int findGCD(int m, int n) {
        if (m % n == 0){
            return n;
        } else {
            System.out.println(m + " % " + n + " = " + (m % n));
            return findGCD(n, m % n);
        }
    }
}