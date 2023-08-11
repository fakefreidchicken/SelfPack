package com.syx.tree;

/**
 * ClassName: BinarySortTree <br/>
 * Description: <br/>
 * date: 2023/8/11 13:43 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new BSTNode(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

        //测试一下删除叶子结点


        binarySortTree.delNode(12);


        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);


        System.out.println("root=" + binarySortTree.getRoot());


        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
    private BSTNode root;
    public BSTNode getRoot() {
        return root;
    }
    public BSTNode search(int data){
        if(root == null) {
            return null;
        }else{
            return root.search(data);
        }
    }
    public BSTNode searchParent(int data){
        if(root == null) {
            return null;
        }else{
            return root.searchParent(data);
        }
    }

    /**
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(BSTNode node) {
        BSTNode target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.data);
        return target.data;
    }


    /**
     * 删除结点
     * @param data
     */
    public void delNode(int data) {
        if(root == null) {
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            BSTNode targetNode = search(data);
            //如果没有找到要删除的结点
            if(targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            BSTNode parent = searchParent(data);
            //如果要删除的结点是叶子结点
            if(targetNode.left == null && targetNode.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if(parent.left != null && parent.left.data == data) { //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.data == data) {//是右子结点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) { //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.data = minVal;
            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if(targetNode.left != null) {
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.left.data == data) {
                            parent.left = targetNode.left;
                        } else { //  targetNode 是 parent 的右子结点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.left.data == data) {
                            parent.left = targetNode.right;
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    public void add(BSTNode node) {
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }
    public void infixOrder() {
        if(root != null){
            root.infixOrder();
        }else{
            System.out.println("空树");
        }
    }
}
class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    /**
     * 查找要删除的结点
     * @param data  希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public BSTNode(int data){
        this.data = data;
    }

    public BSTNode search (int data){
        if(data == this.data){
            return this;
        }
        if(data < this.data){
            if(this.left == null){
                return null;
            }
            return this.left.search(data);
        }
        if(data > this.data){
            if(this.right == null){
                return null;
            }
            return this.right.search(data);
        }
        return null;
    }

    /**
     * 查找要删除结点的父结点
     * @param data 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public BSTNode searchParent (int data){
        if((this.left != null && this.left.data == data) ||
        (this.right!= null && this.right.data == data)){
            return this;
        }else{
            if(data < this.data && this.left!=null){
                return this.left.searchParent(data);
            }else if(data > this.data && this.right!= null){
                return this.right.searchParent(data);
            }else {
                return null;
            }
        }
    }

    public void add(BSTNode node){
        if(node == null){
            return;
        }
        if(node.data < this.data){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if(this.left!= null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!= null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                '}';
    }
}
