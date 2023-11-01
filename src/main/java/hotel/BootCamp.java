package hotel;

/*
# array is sorted
# find a sum

Найти два числа, сумма которых равно числу К

nums = [-4, -3, 2, 4, 8, 10, 15] K

K = 5 [-3, 8]
K = 100 [,]



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
public class BootCamp {
    int k = 5;
    static int[] nums = {-4, -3, 2, 4, 8, 10, 15};


    String[] s1 = {"aa", "bb"};
    String[] s2 = {"a", "abb"};
    String str = String.join("", s1);
    //.equals(String.join("", s2)))

    //решение 2 задачи java, к слову что в javа нет джоинов
    public static void main(String[] args) {

   System.out.println(Summ().toString());

    }

    public static  int[] Summ() {

        for (int i = 0; i < nums.length; i++) {
            int numberToFind = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == numberToFind) {
                    return new int[]{nums[i], nums[mid]};
                }
                if (numberToFind < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{};
    }


}
