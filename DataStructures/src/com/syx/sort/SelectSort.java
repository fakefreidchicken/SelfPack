package com.syx.sort;

/**
 * ClassName: SelectSort <br/>
 * Description: <br/>
 * date: 2023/8/4 9:15 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class SelectSort<T extends Comparable<T>> {

    public void selectSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = {64, 34, 25, 25, 22, 11, 90};
        SelectSort<Integer> intSelectionSort = new SelectSort<>();
        intSelectionSort.selectSort(intArr);
        System.out.println("排序后的整数数组：");
        for (int num : intArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
