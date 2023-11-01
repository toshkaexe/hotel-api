package hotel;

import java.util.Arrays;

public class FindRange {
    public static void main(String[] args) {
        int[] sortedArray = {5, 7, 8, 8, 8,9, 10};
        int k = 9;

        int[] result = findPositionsOfK(sortedArray, k);
        System.out.println("Позиции числа " + k + " в массиве: " + Arrays.toString(result));
    }


    public static int[] findPositionsOfK(int[] nums, int k) {
        int start = findStartPosition(nums, k);
        int end = findEndPosition(nums, k);

        if (start > end) {
            return new int[]{-1, 1};
        } else {
            return new int[]{start, end};
        }
    }

    public static int findStartPosition(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= k) {
                end = mid - 1;
                if (nums[mid] == k) {
                    result = mid;
                }
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static int findEndPosition(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= k) {
                start = mid + 1;
                if (nums[mid] == k) {
                    result = mid;
                }
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
