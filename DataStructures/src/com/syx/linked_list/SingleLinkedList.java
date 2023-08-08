package com.syx.linked_list;

import java.util.Stack;

/**
 * ClassName: SingleLinkedList <br/>
 * Description: <br/>
 * date: 2023/7/24 14:32 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class SingleLinkedList {
    private Node head = new Node(0, "");

    public static void main(String[] args) {
        Node node1 = new Node(1,"q");
        Node node2 = new Node(2,"w");
        Node node3 = new Node(3,"e");
        Node node4 = new Node(4,"r");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.list();
        singleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }

    public Node getHead() {
        return head;
    }

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;//判断添加的编号是否已经存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("待插入节点已存在，id为：" + node.id);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void updateById(Node node) {
        Node temp = head;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
        } else {
            System.out.println("链表中没有找到id为:" + node.id + "的节点");
        }
    }

    public void deleteById(int id) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点，id为：" + id + "不存在");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            //判断是否为链表最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * @param node 传入链表的头结点
     * @return 有效的节点个数
     */
    public int getLength(Node node) {
        int length = 0;
        if (node.next == null) {
            return length;
        }
        Node temp = node.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public Node findLastIndexNode(Node head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index <= 0 || index > length) {
            return null;
        }
        Node temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseList(Node head){
        //空链表或者只有一个节点不需反转
        if(head.next == null || head.next.next == null){
            return ;
        }

        Node temp = head.next;
        Node next = null;//指向当前节点的下一个节点
        Node reverseHead = new Node(0,"");
        //每遍历一次原链表就将其节点放到reverseHead的头部
        while (temp != null){
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }
    //逆序打印链表，用栈来存，顺序遍历，存入栈中，在遍历栈输出即可
    public void reversePrint(Node head){
        if(head.next == null){
            return;
        }
        if(head.next.next == null){
            System.out.println(head.next);
        }
        Stack<Node> nodes = new Stack<>();
        Node temp = head.next;
        while (temp != null){
            nodes.push(temp);
            temp = temp.next;
        }
        while (nodes.size() > 0){
            System.out.println(nodes.pop());
        }
    }

}

class Node {
    public int id;
    public String name;
    public Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + "}";
    }
}