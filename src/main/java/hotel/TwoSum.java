package hotel;

import java.lang.reflect.Array;
import java.util.Arrays;
// Дан массив целых чисел, массив упорядочен
// Найти такие два числа, что сумма их равна k
public class TwoSum {
    public static void main(String[] args) {
        var initArray = new int[]{-4, -3, 2, 4, 8, 10, 15};
        int k = 5;
        int[] summ = Summ(initArray, k);
        System.out.println(Arrays.toString(summ));
    }

    public static int[] Summ(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int numberTiFind = k - nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == numberTiFind) {
                    return new int[]{nums[i], nums[mid]};
                }
                if (numberTiFind < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }
        return new int[]{};
    }
}
