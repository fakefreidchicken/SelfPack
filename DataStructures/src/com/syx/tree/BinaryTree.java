package com.syx.tree;

/**
 * ClassName: BinaryTree <br/>
 * Description: <br/>
 * date: 2023/8/7 20:36 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class BinaryTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    public TreeNode getRoot() {
        return root;
    }

    public void preOrder() {
        if (this.root!= null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (this.root!= null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root!= null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
}

class TreeNode {
    private int id;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left!= null) {
            this.left.preOrder();
        }
        if (this.right!= null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left!= null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!= null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left!= null) {
            this.left.postOrder();
        }
        if (this.right!= null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }
}
