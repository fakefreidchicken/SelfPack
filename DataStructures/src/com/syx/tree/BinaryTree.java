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

    public void deleteTreeNode(int id) {
        if (this.root != null) {
            if (this.root.getId() == id) {
                this.root = null;
            } else {
                this.root.deleteTreeNode(id);
            }
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public TreeNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public TreeNode infixOrderSearch(int id) {
        if (this.root != null) {
            return this.root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public TreeNode postOrderSearch(int id) {
        if (this.root != null) {
            return this.root.postOrderSearch(id);
        } else {
            return null;
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

    public void deleteTreeNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteTreeNode(id);
        }
        if (this.right != null) {
            this.right.deleteTreeNode(id);
        }
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public TreeNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }
        TreeNode result = null;
        if (this.left != null) {
            result = this.left.preOrderSearch(id);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.preOrderSearch(id);
        }
        return result;
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public TreeNode infixOrderSearch(int id) {
        TreeNode result = null;
        if (this.left != null) {
            result = this.left.infixOrderSearch(id);
        }
        if (result != null) {
            return result;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            result = this.right.infixOrderSearch(id);
        }
        return result;
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }

    public TreeNode postOrderSearch(int id) {
        TreeNode result = null;
        if (this.left != null) {
            result = this.left.postOrderSearch(id);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.postOrderSearch(id);
        }
        if (result != null) {
            return result;
        }
        if (this.id == id) {
            return this;
        }
        return result;
    }
}
