import java.util.Scanner;

/**
 * Recursive Digit Sum
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem?h_r=internal-search
 */
public class Solution {


    /**
     * Complete the superDigit function below.
     */
    static long superDigit0(String n, long k) {
    
        // **** ****
        long p = 0;

        // **** traverse the string ****
        for (int i = 0; i < n.length(); i++) {

            // **** current digit ****
            long v = n.charAt(i) - '0';

            // **** multiply it by k ****
            v *= k;

            // **** add it to p ****
            p += v;
        }

        // **** call recursive function ****
        long sd = findSD(p);

        // **** return super digit ****
        return (int)sd;
    }


    /**
     * Find the super digit of the specified string.
     * Recursive call.
     */
    static long findSD(long p) {

        // **** base condition ****
        if (p <= 9)
            return p;

        // **** sum digits ****
        int sum = 0;
        while (p > 0) {

            // **** ****
            sum += p % 10;

            // **** ****
            p /= 10;
        }

        // **** ****
        p = sum;

        // **** recurse ****
        long sd = findSD(p);

        // **** ****
        return sd;
    }


    /**
     * Using streams.
     * Recursive call.
     */
    public static int superDigit(String n, int k) {

        // **** initial sum of digits ****
        n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";

        // **** base condition and recursion ****
        return (n.length() > 1) ? superDigit(n, 1) : Character.getNumericValue(n.charAt(0));
    }


    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read n & k ****
        String[] nk = sc.nextLine().split(" ");

        // **** close scanner ****
        sc.close();

        // **** extract n & k ****
        String n    = nk[0];
        int k       = Integer.parseInt(nk[1]);

        // **** display n & k ****
        System.out.println("main <<< n ==>" + n + "<== k: " + k);
       
        // **** generate and display super digit ****
        System.out.println("main <<< superDigit0: " + superDigit0(n, k));

        // **** generate and display super digit ****
        System.out.println("main <<<  superDigit: " + superDigit(n, k));
    }

}