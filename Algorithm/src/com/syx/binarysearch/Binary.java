package com.syx.binarysearch;

/**
 * ClassName: Binary <br/>
 * Description: <br/>
 * date: 2023/8/15 14:33 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class Binary {

    public static void main(String[] args) {
        //测试
        int[] arr = {1,3, 8, 10, 11, 67};
        int index = binarySearch(arr, 8);
        System.out.println("index=" + index);
    }

    /**
     * 二分查找的非递归实现
     * @param arr 待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if ( arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
