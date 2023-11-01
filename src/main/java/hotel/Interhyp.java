package hotel;


import java.util.Random;

public class Interhyp {

    public static void main(String[] args)
    {
        int size = 8;
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
        // Заполняем матрицу случайным образом, с учетом условий
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    int maxPossibleValue = Math.min(size - i, size - j);
                    int value = random.nextInt(maxPossibleValue) + 1;
                    // Заполняем горизонтальные и вертикальные линии
                    for (int k = 0; k < value; k++) {
                        if (i + k < size) matrix[i + k][j] = 1;
                        if (j + k < size) matrix[i][j + k] = 1;
                    }
                }
            }
        }

        // Выводим матрицу на экран
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    /*

        public int[] Summ(){
            for (int i = 0; i < nums.length; i++){
                int numberToFind = k = nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while(left <= right){
                    int mid = left + (right - left)/2;
                    if (nums[mid] == numberToFind){
                        return new int[] {nums[i], nums [mid]};
                    }
                    if ( numberToFind < nums [mid]){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return new int[,]
        }
        */
    public static class BootCamp {
    }
}
