package math;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        } else {
            BigInteger result = BigInteger.valueOf(n);
            return result.multiply(factorial(n - 1));
        }
    }
}
