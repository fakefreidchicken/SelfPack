package com.syx.sort;

/**
 * ClassName: QucikSort <br/>
 * Description: <br/>
 * date: 2023/8/4 14:59 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class QucikSort<T extends Comparable<T>> {

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        // 选择最右边的元素作为基准
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
