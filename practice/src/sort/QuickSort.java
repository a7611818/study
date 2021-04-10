package sort;

/**
 * @author ybq
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println("2020".compareTo("2021"));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int low = start, high = end;

        int temp = arr[start];
        while (low < high) {

            while (low < high && arr[high] > temp) {
                high--;
            }
            arr[low] = arr[high];


            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;

        quickSort(arr, start, low - 1);
        quickSort(arr, low + 1, end);
    }
}
