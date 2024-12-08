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
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            boolean flag = true;
            boolean ans1 = Ex1.isNumber(num1);
            if(num1.equals("quit")){
                flag = false;
            }
            if(!num1.equals("quit")) {
                System.out.printf(num1 + " is number: " + ans1 + ", value = " + Ex1.number2Int(num1));
                System.out.println();
                if (isNumber(num1)){
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                }
                else{
                    System.out.printf("ERR: num1 is in the wrong format! " + num1);
                    flag = false;
                }
            }
            if(!num2.equals(quit) && flag){
                boolean ans2 = Ex1.isNumber(num2);
                if(ans2) {
                    System.out.println(num2 + " is number: True , value = " + Ex1.number2Int(num2));
                    System.out.println("Enter a base for out put - [2,16]: " );
                    String outPutBase = sc.next();
                    boolean isBase = false;
                    for(int i = 2; i <= 16 && !isBase; i++){
                        if(outPutBase.contains(String.valueOf(i))){
                            isBase = true;
                        }
                    }
                    if(isBase){
                        int firstNumber = Ex1.number2Int(num1);
                        int secondNumber = Ex1.number2Int(num2);
                        int addNumbers = firstNumber + secondNumber;
                        int theOutPutBase = Integer.parseInt(outPutBase);
                        String finalAdd = Ex1.int2Number(addNumbers, theOutPutBase);
                        int multiNumbers = firstNumber * secondNumber;
                        String finalMulti = Ex1.int2Number(multiNumbers, theOutPutBase);
                        String[] maxCheck = {num1, num2, finalAdd, finalMulti};
                        int maxNum = Ex1.maxIndex(maxCheck);
                        System.out.println(addNumbers +""+ multiNumbers);
                        System.out.println("Max number over ["+ num1+","+ num2 +","+ finalAdd +","+ finalMulti + "]is: " + maxNum);

                    }
                    else{
                        System.out.println("ERR: wrong base, should be [2,16], got (" + outPutBase + ")");
                    }
                }
                else{
                    System.out.printf("ERR: num2 is in the wrong format! " + num2);
                }
            }

        }
        System.out.println("quiting now...");
    }
}
