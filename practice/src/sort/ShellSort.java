package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] ints = {3, 5, 6, 1, 1, 2, 35, 67, 1};
        shellSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void shellSort(int[] ints) {
        //增量
        for (int d = ints.length / 2; d > 0; d /= 2) {
            for (int i = d; i < ints.length; i++) {

                for (int j = i; j >= d; j -= d) {
//                    每个分组平行遍历，可以减少代码量
                    if (ints[j] < ints[j - d]) {
                        int temp = ints[j];
                        ints[j] = ints[j - d];
                        ints[j - d] = temp;
                    }
                }
            }
        }
    }
}
