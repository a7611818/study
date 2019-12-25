# 选择排序之双重选择

1. 排序思路：

   遍历比较，每次找到最小值，每一次遍历最后移动。

``` java
private static void doubleSelect(int[] arr) {
        //1、当前最大值与最小值的坐标赋予最边缘的两个
        //2、用坐标为min和max的值循环比较数组其他的值，若存在更小或者更大的值，则更新min或max坐标。
        //3、循环2，直至排序完成。

        for (int j = 0; j < arr.length / 2; j++) {
            int min = j, max = arr.length - j - 1;

            for (int i = j; i < arr.length - j; i++) {
                //若arr[i]<=arr[min] ,则更新min
                if (arr[i] < arr[min]) {
                    min = i;
                    continue;
                }
                if (arr[i] > arr[max]) {
                    max = i;
                    continue;
                }
            }
            //需要记住，这是第几次交换。用来找到现阶段最大值与最小值的位置,所以传入j
            change(arr, min, max, j);
        }
    }
```

```java
    //第一次min和max找到，开始交换值
    private static void change(int[] arr, int min, int max, int count) {
        int temp = arr[count];
        arr[count] = arr[min];
        arr[min] = temp;
        //若最最大值在最左边，则会在最小值传输的时候，最大值的位置会改变，所以需要更新max值。
        if (max == count)
            max = min;

        temp = arr[arr.length - count - 1];
        arr[arr.length - count - 1] = arr[max];
        arr[max] = temp;
    }
```

###  难点

1. 双重排序中嵌套的里面一层循环，从什么时候开始，什么时候结束。
2. 交换值时候存在一个特殊情况，那就是第二次交换的值，可能在第一次交换的时候给换走了