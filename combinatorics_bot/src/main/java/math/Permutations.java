package math;

import service.Service;

import static math.Factorial.factorial;

//перестановки
public class Permutations {
    //без повторений
    public static long permutationsWithoutRepetition(int n) {
        if (n < 0) {
            return 0;
        } else {
            return factorial(n);
        }
    }

    //с повторениями
    public static long permutationsWithRepetition(int n, int[] numbers) {
        if (n == Service.sumArray(numbers)) {
            long product = 1;
            for (int i = 0; i < numbers.length; i++) {
                long numFact = Factorial.factorial(numbers[i]);
                product *= numFact;
            }
            return factorial(n)/product;
        } else {
            return 0;
        }
    }
}
