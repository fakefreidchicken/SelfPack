package com.syx.sort;

/**
 * ClassName: BubbleSort <br/>
 * Description: <br/>
 * date: 2023/8/3 17:23 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class BubbleSort<T extends Comparable<T>> {

    public void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // 交换arr[j]和arr[j+1]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // 如果在一轮遍历中没有发生交换，则表示数组已经有序，提前退出排序
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer [] arr = {20,9,-1,6,98,29,45,5};
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.bubbleSort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
