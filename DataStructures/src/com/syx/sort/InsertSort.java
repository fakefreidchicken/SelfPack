package com.syx.sort;

/**
 * ClassName: InsertSort <br/>
 * Description: <br/>
 * date: 2023/8/4 9:48 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class InsertSort<T extends Comparable<T>> {

    public void insertSort(T[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            // 将元素逐个向右移动，直到找到合适的插入位置
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 插入元素到合适的位置
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = {69, 34, 25, 25, 22, 11, 90};
        InsertSort<Integer> insertSort = new InsertSort<>();
        insertSort.insertSort(intArr);
        System.out.println("排序后的整数数组：");
        for (int num : intArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
