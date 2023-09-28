package math;

import static math.Factorial.factorial;

//размещения
public class Placements {
    //без повторений
    public static long placementsWithoutRepetition(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        } else {
            long numerator = factorial(n);
            long denominator = factorial(n - k);
            return numerator / denominator;
        }
    }

    //с повторениями
    public static long placementsWithRepetition(int n, int k) {
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
