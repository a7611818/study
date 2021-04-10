package sort;

import java.util.Arrays;

/**
 * @author ybq
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 1, 0, 5, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }


}
