/*-----------------------------------------------------------------------------------
 *
 *	sum( n ) is a summation algorithm defined as follows:
 *
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *
 *	(2)	    sum( n ) = n + sum( n - 1 )
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 )
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1
 *
 *----------------------------------------------------------------------------------- */

/**
 * RecursionLab.java
 * ========================
 * @author M Mustafa Narejo
 * @version 5/15/2024
 */

import java.awt.Dimension;

import javax.swing.*;

public class RecursionLab {
    private static JTextArea myArea = new JTextArea();
    private static int count = 0;

    public static void main(String args[]) { // invoke the recursive method here...
        /**
         * TODO: switch between the two commented lines below and execute this code,
         * observing the output for both the iterative solution and the recursive solution.
         * To watch the recursive behaviour in action, set a breakpoint on the if statement
         * inside the recursiveSum() function
         *
         */
        //int solution = iterativeSum(20);
        int solution = recursiveSum( 20 );
        System.out.println("Factorial of 5 (recursive): " + factorialRecursive(5)); // 120
        System.out.println("Factorial of 5 (iterative): " + factorialIterative(5));

        System.out.println("2^3 (brute-force recursive): " + powerRecursive(2, 3)); // 8
        System.out.println("2^3 (optimized recursive): " + powerOptimized(2, 3));

        System.out.println("Fibonacci of 7: " + fibonacci(7));

        System.out.println("Combination of 5 choose 3: " + combinations(5, 3));

        // Some GUI details
        myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
        JScrollPane myPane = new JScrollPane(myArea);
        myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myPane.setPreferredSize(new Dimension(600, 300));
        JOptionPane.showMessageDialog(null, myPane);

        // good form to include an exit call when GUIing in Java
        System.exit(0);
    }

    /**
     * Recursion is similar to iterative looping, but we
     * use method calls to repeat computations (or decompose the problem)
     * instead of explicit looping control structures.
     */
    public static int recursiveSum(int n) {
        updateRecursiveDisplay(n); // overhead for nice output, not required
        if (n == 1)                // if we're at the base case...
            return 1;              // then return the answer to the simplest problem which we know how to solve
        else                       // otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
            return (n + recursiveSum(n - 1));

        // for this method to terminate, we must be breaking the problem down into smaller
        // and smaller problems, until we reach the simplest form of the problem which we know
        // how to solve (in this case, it's the fact that sum( 1 ) == 1 )
    }

    //

    /**
     * The iterative counterpart to the above recursion. Notice how it's longer?
     * At times, an iterative solution may require more code than the recursive counterpart,
     * but, the recursive solution is slower and more memory intensive. We can always
     * recast recursion as iteration.
     */
    public static int iterativeSum(int i) {
        int total = 0;

        for (int n = i; n >= 1; n--) {
            updateIterativeDisplay(n);
            total = total + n;
        }
        return total;
    }

    public static void updateIterativeDisplay(int n) {
        count++;
        String text = myArea.getText();

        text += "\n/*******************Loop iteration " + count + "**************************************";
        text += "\n Calling iterativeSum( int n = " + n + " ). Total += " + n;
        text += "\n***************************************************************************/";

        myArea.setText(text);
    }

    // ignore this method unless interested in the output string
    public static void updateRecursiveDisplay(int n) {
        count++;
        String text = myArea.getText();

        if (count == 1) {
            text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
            text += "       CALL STACK IN MAIN MEMORY                ";
        }

        text += "\n/*******************Method invocation " + count + "*********************";

        text += "\n Calling recursiveSum( int n = " + n + " ). ";
        text += "\n The return statement from this function will resolve in " + (n - 1) + " more recursive method calls...";

        if (n != 1) {
            text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( " + (n - 1) + " ));";
        } else {
            text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
            text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
            text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
        }
        text += "\n***************************************************************************/";

        myArea.setText(text);
    }

    public static int factorialRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }

    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    public static int powerRecursive(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * powerRecursive(x, n - 1);
        }
    }
    public static int powerOptimized(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = powerOptimized(x, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return x * halfPower * halfPower;
        }
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int combinations(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        } else {
            return combinations(n - 1, r - 1) + combinations(n - 1, r);
        }
    }

}
