package assignments.ex1;
import java.util.Arrays;
import java.util.Scanner;


import static assignments.ex1.Ex1.*;
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
            boolean ans1 = Ex1.isNumber(num1);
            if(!num1.equals("quit")) {
                System.out.printf(num1 + " is number: " + ans1 + " value = " + Ex1.number2Int(num1));
                System.out.println();
                System.out.println("Ex1 class solution:");
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
            }
            if(!num2.equals(quit) && ans1){
                boolean ans2 = Ex1.isNumber(num2);
                System.out.printf(num2 + " is number: " + ans2 + " value = " + Ex1.number2Int(num2));
            }
        }
        System.out.println("quiting now...");
    }
}
