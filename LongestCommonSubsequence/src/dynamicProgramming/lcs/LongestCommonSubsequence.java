package dynamicProgramming.lcs;

/**
 * Finds Longest Common Subsequence of given two Strings
 *
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */
public class LongestCommonSubsequence {
    // Global variables
    private int [][] c;// Matrix
    private char[] x; // Char arr of String A
    private char[] y; // Char arr of String B
    private int printCount; // To create a new line after printing a LCS

    /**
     * Constructor for LCS_2018_E_007_L9
     * Creates Char arr of String A and B
     * Creates the empty Matrix c
     * @param A
     * @param B
     */
    public LongestCommonSubsequence(String A, String B) {
        // Initializing the global variables
        x = new char[A.length()];
        y = new char[B.length()];
        c = new int[A.length() + 1][B.length() + 1];
        printCount = 0;
        // Creating the Char arrays of String A and B
        for(int i = 0; i < A.length(); i++) { x[i] = A.charAt(i); }
        for(int i = 0; i < B.length(); i++) { y[i] = B.charAt(i); }
        //Creating the empty Matrix c
        for(int i  = 0; i < A.length() + 1; i++) {
            for(int j = 0; j < B.length() + 1; j++) {
                c[i][j] = 0;
            }
        }
    }

    /**
     * Prints the Longest Common Subsequences
     *
     */
    public void printLCS() {
        System.out.println("\nLongest Common Subsequences : ");
        // Updates the matrix c
        for(int i = 1 ;i < x.length + 1; i++){
            for(int j = 1;j < y.length + 1; j++) {
                // If x[i - 1] == y[j - 1], then c[i][j] = c[i - 1][j - 1] + 1 (Adding 1 to the diagonal value)
                // else  c[i][j] = max value of c[i - 1][j] and c[i][j - 1]
                c[i][j] = x[i - 1] == y[j - 1] ? c[i - 1][j - 1] + 1 : max(c[i - 1][j],c[i][j - 1]);
            }
        }
        traceBack(x.length,y.length);   // Calling the method traceBack
    }

    /**
     * Traces back from the end to beginning to print the Longest Common Subsequences
     *
     * @param i Maximum i value of the matrix
     * @param j Maximum j value of the matrix
     */
    private void traceBack(int i,int j) {
        // Returns when the method reaches the top
        if(i == 0 || j == 0) return;

        int temp = c[i][j]; // Temp value to compare with previous elements of the matrix c

        // Going back to left
        if(temp == c[i][j - 1]) traceBack(i,j - 1);
        // Going back to up
        else if(temp == c[i - 1][j]) traceBack(i - 1,j);
        // Going back in the diagonal
        else{
            traceBack(i - 1,j - 1);
            System.out.print(x[i - 1]); // Prints the Char
            printCount++;   // Increases print count
            // Creates new line when the printCount reached the size of the LCS
            if(printCount % c[x.length][y.length] == 0) System.out.println();
        }
        return;
    }

    /**
     * Finds the maximum number of given 2 integers
     *
     * @param p int 1
     * @param q int 2
     * @return the maximum number
     */
    private int max(int p, int q) {
        if(q > p) return q; // Returns q when q>p
        else return p;   // Returns q when p>q || p == q
    }

}
