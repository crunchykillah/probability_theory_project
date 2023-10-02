package math;

import java.math.BigInteger;

import static math.Factorial.factorial;

//сочетания
public class Combinations {
    //без повторений
    public static BigInteger combinations(int n, int k) {
        if (k < 0 || k > n) {
            return BigInteger.ZERO;
        } else {
            BigInteger numerator = factorial(n);
            BigInteger denominator = factorial(k).multiply(factorial(n - k));
            return numerator.divide(denominator);
        }
    }

    public static BigInteger combinationsWithRepetition(int n, int k) {
        if (k < 0 || n < 0) {
            return BigInteger.ZERO;
        } else {
            BigInteger numerator = factorial(n + k - 1);
            BigInteger denominator = factorial(k).multiply(factorial(n - 1));
            return numerator.divide(denominator);
        }
    }


}
