package com.syx.tree;

import com.syx.sort.MergeSort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: HeapSort <br/>
 * Description: <br/>
 * date: 2023/8/10 13:57 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[12000000];
        for (int i = 0; i < 12000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
//        System.out.println("归并排序后=" + Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, i, 0);
        }
    }

    public static void adjustHeap(int[] arr, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest!= i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            adjustHeap(arr, length, largest);
        }
    }
}
