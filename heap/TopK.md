## TopK的问题
基本思路：

1. 如果是求TopK的最小值，就构建K数量的大顶堆
2. 数组中余下来的值再与堆顶的比较，如果比堆顶的值小，就替换堆顶的值再堆化

```java
    //获取最小的Topk
    private static int[] topMinK (int[] array, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = array[i];
        }
        buildMaxHeap(top);
        for (int i = k; i < array.length; i++) {
            if (array[i] < top[0]) {
                setTop(top, array[i]);
            }
        }
        return top;
    }

    //构建最大堆
    private static void buildMaxHeap (int[] array) {
        int len = array.length;
        for (int i = len/2 -1; i >= 0; i--) {
            heapify(array, i, len);
        }
    }

    private static void setTop(int[] array, int top) {
        array[0] = top;
        heapify(array, 0, array.length);
    }

    //堆化
    private static void heapify (int[] array, int index, int len) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < len && array[left] > array[largest])
            largest = left;
        if (right < len && array[right] > array[largest])
            largest = right;
        if (largest != index) {
            swap(array, index, largest);
            heapify(array,largest, len);
        }
     }

    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
```