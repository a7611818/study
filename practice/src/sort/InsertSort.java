package sort;

import java.util.Arrays;

/**
 * @author ybq
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = {
                1, 3, 7, 3, 6, 8, 1
        };
        insertSort(ints);

        System.out.println(Arrays.toString(ints));
    }

    private static void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int cur = i;
            while (cur > 0 && ints[cur] < ints[cur - 1]) {
                int temp = ints[cur];
                ints[cur] = ints[cur - 1];
                ints[--cur] = temp;
            }
        }
    }
}
