package sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ybq
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] ints = {14123, 4, 5, 1, 2, 99, 44};
        radixSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void radixSort(int[] ints) {
        //10个大桶
        ArrayList<Queue<Integer>> lists = new ArrayList<>(ints.length);

        //计算最大数
        Integer max = Integer.MIN_VALUE;
        for (int num : ints) {
            max = Math.max(max, num);
        }

        int maxLength = Integer.toString(max).length();

        //准备桶
        for (int i = 0; i < 10; i++) {
            lists.add(new LinkedList<>());
        }

        //桶已准备好，下面进行入桶和出桶
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //入桶
            for (int num : ints) {
                lists.get(num / n % 10).add(num);
            }

            //出桶
            for (int j = 0, buck = 0; j < ints.length; j++) {
                if (lists.get(buck).size() > 0) {
                    ints[j] = lists.get(buck).poll();
                } else {
                    j--;
                    buck++;
                }
            }
        }
    }
}
