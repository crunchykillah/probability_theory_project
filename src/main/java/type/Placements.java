package type;
import static type.Factorial.factorial;

public class Placements {
    // Метод для вычисления размещений без повторений A(n, k)
    public static long arrangementsWithoutRepetition(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        } else {
            long numerator = factorial(n);
            long denominator = factorial(n - k);
            return numerator / denominator;
        }
    }

    // Метод для вычисления размещений с повторениями n^k
    public static long arrangementsWithRepetition(int n, int k) {
        if (k < 0) {
            return 0;
        } else {
            long result = 1;
            for (int i = 0; i < k; i++) {
                result *= n;
            }
            return result;
        }
    }

}
