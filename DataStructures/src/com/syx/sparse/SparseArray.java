package com.syx.sparse;

/**
 * ClassName: SparseArray <br/>
 * Description: 泛型封装的数组与稀疏数组的转换<br/>
 * date: 2023/7/21 14:37 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class SparseArray {
    /**
     *
     * @param t 传入的二维数组
     * @param k 平凡值
     * @param <T> 泛型
     * @return
     */
    public static  <T> Object[][] toSparseArray(T[][] t,T k){
        int sum = 0;//记录二维数组中非平凡值的个数
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(t[i][j] != k) sum++;
            }
        }

        //创建稀疏数组
        Object [][] sparseArray = new Object[sum+1][3];
        sparseArray[0][0] = t.length;
        sparseArray[0][1] = t[0].length;
        sparseArray[0][2] = sum;
        int count = 1;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(t[i][j] != k){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = t[i][j];
                    count++;
                }
            }
        }
        return sparseArray;
    }

    /**
     *
     * @param t 稀疏数组
     * @param k 平凡值
     * @param <T> 泛型
     * @return
     */
    public static  <T> T[][] toArray(Object[][] t,T k){
        T [][] array =(T[][]) new Object[(int)t[0][0]][(int)t[0][1]];
        for(int i =0;i<array.length;i++){
            for (int j =0;j<array[i].length;j++){
                array[i][j] = k;
            }
        }
        for(int i =1;i<t.length;i++){
            array[(int)t[i][0]][(int)t[i][1]] = (T)t[i][2];
        }
        return array;
    }

}
