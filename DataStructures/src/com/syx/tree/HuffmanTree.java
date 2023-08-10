package com.syx.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: HuffmanTree <br/>
 * Description: <br/>
 * date: 2023/8/10 14:32 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);

        //测试
        preOrder(root);

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else{
            System.out.println("控树不能遍历");
        }
    }

    public static Node createHuffmanTree(int[] arr) {

        List<Node> nodes = new ArrayList<Node>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node node1 = nodes.get(0);
            Node node2 = nodes.get(1);
            Node newNode = new Node(node1.value + node2.value);
            newNode.left = node1;
            newNode.right = node2;
            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

}
class Node implements Comparable<Node> {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    public void preOrder(){
        System.out.println(this);
        if(left!=null){
            this.left.preOrder();
        }
        if(right!=null){
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}