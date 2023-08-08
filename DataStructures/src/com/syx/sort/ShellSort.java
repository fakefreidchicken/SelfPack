package com.syx.sort;

/**
 * ClassName: ShellSort <br/>
 * Description: <br/>
 * date: 2023/8/4 14:36 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class ShellSort<T extends Comparable<T>> {

    public void shellSort(T[] arr) {
        int n = arr.length;

        // 初始步长为数组长度的一半，逐渐缩小步长直到为1
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对每个步长进行插入排序
            for (int i = gap; i < n; i++) {
                T key = arr[i];
                int j = i;

                // 将元素逐个向右移动，直到找到合适的插入位置
                while (j >= gap && arr[j - gap].compareTo(key) > 0) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                // 插入元素到合适的位置
                arr[j] = key;
            }
        }
    }
}
