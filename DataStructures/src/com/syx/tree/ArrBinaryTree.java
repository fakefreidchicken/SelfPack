package com.syx.tree;

/**
 * ClassName: ArrBinaryTree <br/>
 * Description: <br/>
 * date: 2023/8/9 8:57 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空");
        }
        System.out.print(arr[index] + " ");
        if (index * 2 + 1 < arr.length) {
            this.preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            this.preOrder(index * 2 + 2);
        }
    }

    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空");
        }
        if (index * 2 + 1 < arr.length) {
            this.infixOrder(index * 2 + 1);
        }
        System.out.print(arr[index] + " ");
        if (index * 2 + 2 < arr.length) {
            this.infixOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空");
        }
        if (index * 2 + 1 < arr.length) {
            this.postOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            this.postOrder(index * 2 + 2);
        }
        System.out.print(arr[index] + " ");
    }

}
