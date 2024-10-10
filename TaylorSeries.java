 /*
 * Name: Ethan Myers
 * Instructor: Dr. Young J Kim
 * Course: Algorithms and Data Structures
 * Due Date: 10/09/2024
 */
public class TaylorSeries {

    // Helper method to convert degrees to radians
    public static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    // Recursive Taylor series for sin(x) approximation
    public static double taylor(double a, double h, int n) {
        if (n == 0) {
            return Math.sin(degreesToRadians(a));
        }

        double term;
        if (n % 4 == 1) {
            term = Math.cos(degreesToRadians(a)) * Math.pow(h, n) / factorial(n);
        } else if (n % 4 == 2) {
            term = -Math.sin(degreesToRadians(a)) * Math.pow(h, n) / factorial(n);
        } else if (n % 4 == 3) {
            term = -Math.cos(degreesToRadians(a)) * Math.pow(h, n) / factorial(n);
        } else {
            term = Math.sin(degreesToRadians(a)) * Math.pow(h, n) / factorial(n);
        }
        return taylor(a, h, n - 1) + term;
    }

    // Method to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        double a = 45;  // we know sin(45º)
        double x = 44;  // we want to approximate sin(44º)
        double h = degreesToRadians(x - a);

        // Approximate using up to the 5th derivative
        double approximation = taylor(a, h, 5);
        System.out.println("Approximation of sin(44º): " + approximation);
    }
}
