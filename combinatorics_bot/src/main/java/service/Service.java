package service;



public class Service {
    public static int[] stringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    public static int[] createIntArray(int num1, int num2) {
        return new int[]{num1, num2};
    }

    public static int[] createIntArray(int num1, int num2, int num3) {
        return new int[]{num1, num2, num3};
    }
}
