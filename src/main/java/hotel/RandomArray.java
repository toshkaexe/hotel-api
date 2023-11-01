package hotel;

import java.util.Arrays;

public class RandomArray {
    public static void main(String[] args) {
        int N = 100;

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }

        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();

        double average = Arrays.stream(array).average().orElse(0);

        // Находим значение, ближайшее к среднему арифметическому
        int closestToAverage = array[0];
        double minDiff = Math.abs(array[0] - average);
        for (int value : array) {
            double diff = Math.abs(value - average);
            if (diff < minDiff) {
                minDiff = diff;
                closestToAverage = value;
            }
        }

        System.out.println("Массив случайных чисел: " + Arrays.toString(array));
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее арифметическое: " + average);
        System.out.println("Число, ближайшее к среднему: " + closestToAverage);
    }

}
