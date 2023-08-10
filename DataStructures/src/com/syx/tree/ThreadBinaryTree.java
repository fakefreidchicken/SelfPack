package com.syx.tree;

/**
 * ClassName: ThreadBinaryTree <br/>
 * Description: <br/>
 * date: 2023/8/9 9:34 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class ThreadBinaryTree {
    private ThreadTreeNode root;
    private ThreadTreeNode pre = null;

    public ThreadTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }

    public ThreadTreeNode getPre() {
        return pre;
    }

    public void setPre(ThreadTreeNode pre) {
        this.pre = pre;
    }

    public void threadTreeNode() {
        this.threadTreeNode(this.root);
    }
    public void deleteThreadTreeNode(int id) {
        if (this.root != null) {
            if (this.root.getId() == id) {
                this.root = null;
            } else {
                this.root.deleteThreadTreeNode(id);
            }
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void threadTreeNode(ThreadTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
       threadTreeNode(treeNode.getLeft());
        if(treeNode.getLeft() == null){
            treeNode.setLeft(pre);
            treeNode.setLeftType(1);
        }
        if(pre != null && pre.getRight() == null){
            pre.setRight(treeNode);
            pre.setRightType(1);
        }
        pre = treeNode;
        threadTreeNode(treeNode.getRight());

    }
    public void threadList() {
        ThreadTreeNode treeNode = this.root;
        while (treeNode != null){
            while (treeNode.getLeftType() == 0){
                treeNode = treeNode.getLeft();
            }
            System.out.println(treeNode);
            while (treeNode.getRightType() == 1){
                treeNode = treeNode.getRight();
                System.out.println(treeNode);
            }
            treeNode = treeNode.getRight();
        }
    }
}
class ThreadTreeNode {
    private int id;
    private ThreadTreeNode left;
    private ThreadTreeNode right;
    /**
     * leftType == 0 表示指向的是左子树，rightType == 1 表示指向的是前驱结点
     * rightType == 0 表示指向的是右子树，rightType == 1 表示指向的是后继结点
     */
    private int leftType;
    private int rightType;

    public ThreadTreeNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThreadTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadTreeNode left) {
        this.left = left;
    }

    public ThreadTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadTreeNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
    @Override
    public String toString() {
        return "ThreadTreeNode{" +
                "id=" + id +
                '}';
    }

    public void deleteThreadTreeNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteThreadTreeNode(id);
        }
        if (this.right != null) {
            this.right.deleteThreadTreeNode(id);
        }
    }
}
