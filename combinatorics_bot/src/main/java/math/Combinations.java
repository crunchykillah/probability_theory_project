package math;

import static math.Factorial.factorial;

//сочетания
public class Combinations {
    //без повторений
    public static long combinations(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        } else {
            return factorial(n) / (factorial(k) * factorial(n - k));
        }
    }
    //с повторениями
    public static long combinationsWithRepetition(int n, int k) {
        if (k < 0 || n < 0) {
            return 0;
        } else {
            return factorial(n + k - 1) / (factorial(k) * factorial(n - 1));
        }
    }
}
