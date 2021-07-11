package dynamicProgramming.lcs;

import java.util.Scanner;

/**
 * Main Class- To demonstrate
 *
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */
public class Demo {
    /**
     * main Class- To demonstrate
     * Please Run this
     *
     * @param args  null
     */
    public static void main(String []args) {
        // Getting user input
        UserInput newInput = new UserInput();
       newInput.getUserInput();

       // Finding the LCS
        LongestCommonSubsequence lcs = new LongestCommonSubsequence(newInput.getA(),newInput.getB());
        lcs.printLCS(); // Printing the LCS

    }
}

/**
 * Gets inputs from the user
 *
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */
class UserInput {
    // Global variables
    private String A;
    private String B;

    /**
     * Constructor for UserInput
     */
    public UserInput() {
        A = null;
        B = null;
    }

    /**
     * Getter for A
     * @return A
     */
    public String getA() {
        return A;
    }
    /**
     * Getter for B
     * @return B
     */
    public String getB() {
        return B;
    }

    /**
     * Takes input data from user
     *
     */
    public void getUserInput() {
        // Giving brief intro to user
        Scanner sc = new Scanner(System.in);
        System.out.println("This program finds The Longest Common Subsequence of given two Strings.");
        System.out.println("A - String 1\nB - String 2\n");

        // Getting String A
        System.out.print("Enter String 1(A) : ");
        A = sc.nextLine();
        // Getting String B
        System.out.print("Enter String 2(B) : ");
        B = sc.nextLine();
    }
}

