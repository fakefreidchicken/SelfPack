package com.syx.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BinarySearch <br/>
 * Description: <br/>
 * date: 2023/8/6 15:15 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
    /**
     * 有多个相同的数值时，如何将所有的数值都查找到
     * 思路分析
     * 1. 在找到mid 索引值，不要马上返回
     * 2. 向mid 索引值的左边扫描，将所有满足的元素的下标，加入到集合ArrayList
     * 3. 向mid 索引值的右边扫描，将所有满足的元素的下标，加入到集合ArrayList
     * 4. 将Arraylist返回
     */
    public static List<Integer> binarySearchAll(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearchAll(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearchAll(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while(true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp 放入到 resIndexList
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);
            //向mid 索引值的右边扫描，将所有满足的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while(true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp 放入到 resIndexList
                resIndexList.add(temp);
                temp += 1;
            }

            return resIndexList;
        }

    }
}
