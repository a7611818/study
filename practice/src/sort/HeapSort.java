package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] ints = {3, 2, 3, 6, 1, 234, 7, 9};
        heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void heapSort(int[] ints) {
//        构建大顶堆
        for (int i = ints.length / 2 - 1; i >= 0; i--) {
            heapAdjust(ints, i, ints.length - 1);
        }

        for (int i = ints.length - 1; i >= 0; i--) {
            //交换最后一个未排好的和第一个
            int temp = ints[0];
            ints[0] = ints[i];
            ints[i] = temp;

            //然后重新构建大顶堆
            heapAdjust(ints, 0, i - 1);
        }

    }

    /**
     * @param ints  树
     * @param index 需要计算的节点
     * @param size  最远的计算边界
     */
    private static void heapAdjust(int[] ints, int index, int size) {
        int child = index * 2 + 1;

        if (child > size) {
            return;
        }

        //找到较大子树
        if (child + 1 <= size && ints[child + 1] > ints[child]) {
            child++;
        }

        //是否需要交换
        if (ints[child] > ints[index]) {
            //交换
            int temp = ints[child];
            ints[child] = ints[index];
            ints[index] = temp;

            //被打乱的子树继续构建大顶堆
            heapAdjust(ints, child, size);
        }

    }
}
