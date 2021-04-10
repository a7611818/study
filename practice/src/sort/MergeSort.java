package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] ints = {5, 5, 412, 7, 54, 7365457, 8, 234, 51, 1};
        System.out.println(Arrays.toString(ints));
        mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }


    private static void mergeSort(int[] ints) {
        merge(ints, 0, ints.length / 2, ints.length - 1);
    }


    private static void merge(int[] ints, int low, int middle, int high) {
        if (low >= high) {
            return;
        }
        //先处理low-middle和middle-high这两个子问题
        merge(ints, low, (low + middle) / 2, middle);
        merge(ints, middle + 1, (middle + 1 + high) / 2, high);

        //当前low-high的归并
        int[] temp = new int[high - low + 1];
        int index = 0;

        int index1 = low, index2 = middle + 1;
        while (index1 <= middle && index2 <= high) {
            if (ints[index1] <= ints[index2]) {
                temp[index++] = ints[index1++];
            } else {
                temp[index++] = ints[index2++];
            }
        }

        //处理剩下的
        while (index1 <= middle) {
            temp[index++] = ints[index1++];
        }
        while (index2 <= high) {
            temp[index++] = ints[index2++];
        }

        //结果置入原数组
        for (int i = low; i <= high; i++) {
            ints[i] = temp[i - low];
        }
    }
}
