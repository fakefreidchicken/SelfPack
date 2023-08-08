package com.syx.sparse;

/**
 * ClassName: Test <br/>
 * Description: <br/>
 * date: 2023/7/21 15:23 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class Test {
    public static void main(String[] args) {
        Integer[][] a = new Integer[11][11];
        int k = 9;

        for (int i = 0 ;i < a.length;i++){
            for (int j =0;j<a[i].length;j++){
                a[i][j] = 9;
            }
        }
        a[1][2] = 1;
        a[2][3] = 2;
        a[4][5] = 6;
        Object [][] sparseArray = SparseArray.toSparseArray(a,k);
        for (int i = 0 ;i < sparseArray.length;i++){
            for (int j =0;j<sparseArray[i].length;j++){
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println("\n");
        }
        Object[][] integers = SparseArray.toArray(sparseArray, k);
        for (int i = 0 ;i < integers.length;i++){
            for (int j =0;j<integers[i].length;j++){
                System.out.printf("%d\t",integers[i][j]);
            }
            System.out.println("\n");
        }
    }
}
