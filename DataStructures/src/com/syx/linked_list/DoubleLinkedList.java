package com.syx.linked_list;

/**
 * ClassName: DoubleLinkedList <br/>
 * Description: <br/>
 * date: 2023/7/27 16:24 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class DoubleLinkedList {
    private DNode head = new DNode(0, "");

    public static void main(String[] args) {
        DNode dNode1 = new DNode(1,"q");
        DNode dNode2 = new DNode(2,"w");
        DNode dNode3 = new DNode(3,"e");
        DNode dNode4 = new DNode(4,"r");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(dNode1);
//        doubleLinkedList.add(dNode2);
//        doubleLinkedList.add(dNode3);
//        doubleLinkedList.add(dNode4);
        doubleLinkedList.addByOrder(dNode3);
        doubleLinkedList.addByOrder(dNode1);
        doubleLinkedList.addByOrder(dNode4);
        doubleLinkedList.addByOrder(dNode2);
        doubleLinkedList.list();
        doubleLinkedList.updateById(new DNode(4,"sdsd"));
        doubleLinkedList.list();
        doubleLinkedList.deleteById(1);
        doubleLinkedList.list();
    }

    public DNode getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DNode temp = head.next;
        while (true) {
            //判断是否为链表最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(DNode dNode) {
        DNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = dNode;
        dNode.pre = temp;
    }

    public void addByOrder(DNode dNode) {
        DNode temp = head;
        boolean flag = false;//判断添加的编号是否已经存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > dNode.id) {
                break;
            } else if (temp.next.id == dNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("待插入节点已存在，id为：" + dNode.id);
        } else {
            if(temp.next == null){
                temp.next = dNode;
                dNode.pre = temp;
            }else {
                temp.next.pre = dNode;
                dNode.pre = temp;
                dNode.next = temp.next;
                temp.next = dNode;
            }
        }
    }

    public void updateById(DNode dNode) {
        DNode temp = head;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == dNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = dNode.name;
        } else {
            System.out.println("链表中没有找到id为:" + dNode.id + "的节点");
        }
    }

    public void deleteById(int id) {
        DNode temp = head;
        if (temp.next == null) {
            System.out.println("删除的链表为空");
            return;
        }
        temp = temp.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            if (temp.next != null) temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
        } else {
            System.out.println("要删除的节点，id为：" + id + "不存在");
        }
    }
}

class DNode {
    public int id;
    public String name;
    public DNode pre;
    public DNode next;

    public DNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DNode{" +
                "id=" + id +
                ", name='" + name + "}";
    }
}
