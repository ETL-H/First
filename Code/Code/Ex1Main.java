package Code;

import java.util.Scanner;
import static assignments.ex1.Code.Ex1.*;

/**
 * Intro2CS, Ex1 - Main class for interacting with the user.
 * Implements a simple calculator for numbers in bases [2,16].
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit", base = "";

        // Main loop for user input and calculations
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = scanner.nextLine();
            boolean ans1 = Ex1.isNumber(num1);
            boolean flag = true;

            // Check if the first number is valid
            if (num1.equals("quit")) {
                flag = false;
            }
            if (!num1.equals("quit")) {
                System.out.printf(num1 + " is number: " + ans1 + ", value = " + Ex1.number2Int(num1));
                System.out.println();
                if (isNumber(num1)) {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = scanner.nextLine();
                } else {
                    System.out.printf("ERR: num1 is in the wrong format! " + num1);
                    flag = false;
                }
            }

            // Process the second number and perform calculations
            if (!num2.equals(quit) && flag) {
                boolean ans2 = Ex1.isNumber(num2);
                if (ans2) {
                    System.out.println(num2 + " is number: true , value = " + Ex1.number2Int(num2));
                    System.out.println("Enter a base for output - [2,16]: ");
                    String outPutBase = scanner.nextLine();
                    boolean isBase = false;

                    // Check if the base is valid
                    for (int i = 2; i <= 16 && !isBase; i++) {
                        if (outPutBase.equals(String.valueOf(i))) {
                            isBase = true;
                        }
                    }

                    if (isBase) {
                        int firstNumber = Ex1.number2Int(num1);
                        int secondNumber = Ex1.number2Int(num2);
                        int addNumbers = firstNumber + secondNumber;
                        int theOutPutBase = Integer.parseInt(outPutBase);

                        // Convert and print results in the specified base
                        String finalAdd = Ex1.int2Number(addNumbers, theOutPutBase);
                        int multiNumbers = firstNumber * secondNumber;
                        String finalMulti = Ex1.int2Number(multiNumbers, theOutPutBase);
                        String[] maxCheck = {num1, num2, finalAdd, finalMulti};
                        int maxNum = Ex1.maxIndex(maxCheck);
                        String maxNumS = maxCheck[maxNum];

                        System.out.println(num1 + " + " + num2 + " = " + finalAdd);
                        System.out.println(num1 + " * " + num2 + " = " + finalMulti);
                        System.out.println("Max number over [" + num1 + ", " + num2 + ", " + finalAdd + ", " + finalMulti + "] is: " + maxNumS);
                    } else {
                        System.out.println("ERR: wrong base, should be [2,16], got (" + outPutBase + ")");
                    }
                } else {
                    System.out.printf("ERR: num2 is in the wrong format! " + num2);
                }
            }
        }
        System.out.println("quitting now...");
    }
}
