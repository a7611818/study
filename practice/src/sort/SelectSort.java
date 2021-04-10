package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] ints = {5, 1, 2, 3, 6, 99, 1};
        selectSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void selectSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[i]) {
                    minInd = j;
                }
            }
            //交换
            int temp = ints[i];
            ints[i] = ints[minInd];
            ints[minInd] = temp;
        }
    }
}
