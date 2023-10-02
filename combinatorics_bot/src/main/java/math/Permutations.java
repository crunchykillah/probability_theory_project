package math;

import service.Service;

import java.math.BigInteger;

import static math.Factorial.factorial;

//перестановки
public class Permutations {
    //без повторений
    public static BigInteger permutationsWithoutRepetition(int n) {
        if (n < 0) {
            return BigInteger.ZERO;
        } else {
            return factorial(n);
        }
    }

    public static BigInteger permutationsWithRepetition(int n, int[] numbers) {
        long sum = Service.sumArray(numbers);
        if (n == sum) {
            BigInteger product = BigInteger.ONE;
            for (int i = 0; i < numbers.length; i++) {
                BigInteger numFact = factorial(numbers[i]);
                product = product.multiply(numFact);
            }
            return factorial(n).divide(product);
        } else {
            return BigInteger.ZERO;
        }
    }
}
