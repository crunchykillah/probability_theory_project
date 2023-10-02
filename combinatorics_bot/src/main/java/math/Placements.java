package math;

import java.math.BigInteger;

import static math.Factorial.factorial;

//размещения
public class Placements {
    //без повторений
    public static BigInteger placementsWithoutRepetition(int n, int k) {
        if (k < 0 || k > n) {
            return BigInteger.ZERO;
        } else {
            BigInteger numerator = factorial(n);
            BigInteger denominator = factorial(n - k);
            return numerator.divide(denominator);
        }
    }

    public static BigInteger placementsWithRepetition(int n, int k) {
        if (k < 0) {
            return BigInteger.ZERO;
        } else {
            BigInteger result = BigInteger.ONE;
            for (int i = 0; i < k; i++) {
                result = result.multiply(BigInteger.valueOf(n));
            }
            return result;
        }
    }
}
