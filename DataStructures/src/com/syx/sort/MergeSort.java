package com.syx.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ClassName: MergeSort <br/>
 * Description: <br/>
 * date: 2023/8/6 14:07 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class MergeSort <T extends Comparable<T>> {

    public static void main(String[] args) {
        //int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        Integer[] arr = new Integer[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
//        System.out.println("归并排序后=" + Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        Integer []temp = new Integer[arr.length];
        new MergeSort<Integer>().mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    private void mergeSort(T[] arr, int left, int right, T[] temp) {
        if(left < right) {
            //中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);

        }
    }

    private void merge(T[] arr, int left, int mid, int right, T[] temp) {
        // 初始化i, 左边有序序列的初始索引
        int i = left;
        //初始化j, 右边有序序列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if(arr[i].compareTo(arr[j]) <= 0) {
                temp[t] = arr[i];
                t ++;
                i ++;
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t ++;
                j ++;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        //左边的有序序列还有剩余的元素，就全部填充到temp
        while( i <= mid) {
            temp[t] = arr[i];
            t ++;
            i ++;
        }

        //右边的有序序列还有剩余的元素，就全部填充到temp

        while( j <= right) {
            temp[t] = arr[j];
            t ++;
            j ++;
        }
        //(三)
        //将temp数组的元素拷贝到arr
        //上面每次复制元素都是从temp的0下标开始的，也就是temp每次都会覆盖
        t = 0;
        int tempLeft = left;
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t ++;
            tempLeft ++;
        }
    }
}
