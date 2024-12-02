package assignments.ex1;
import java.util.Scanner;

import static assignments.ex1.Ex1.isNumber;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chars = "123456789ABCDEFG";
        String num1 = "", num2="", quit = "quit", base ="";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            Ex1.isNumber(num1);
            if (!num1.equals("quit")) {
                // checks isNumber and prints true / false and value
                // ask for second number
            }
            // if second number isn't quit
                // check if it is a number and print is number and value
                // ask for the base [2 - 16]
            // if the base is valid

        }
        System.out.println("quiting now...");
    }
}