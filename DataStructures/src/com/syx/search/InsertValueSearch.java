package com.syx.search;

/**
 * ClassName: InsertValueSearch <br/>
 * Description: 关键字分布比较均匀数据量大的情况下比二分效果好<br/>
 * date: 2023/8/6 15:27 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class InsertValueSearch {

    public int insertValueSearch(int[] arr, int left, int right, int findVal) {

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid, 使用一个插值公式求mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
