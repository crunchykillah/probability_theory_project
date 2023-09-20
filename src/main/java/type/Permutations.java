package type;

import static type.Factorial.factorial;

public class Permutations {
    public static long permutationsWithoutRepetition(int n) {
        if (n < 0) {
            return 0;
        } else {
            return factorial(n);
        }
    }

    // Метод для вычисления перестановок с повторениями P(n, k)
    public static long permutationsWithRepetition(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            return 0;
        } else {
            return (long) Math.pow(n, k);
        }
    }
}
