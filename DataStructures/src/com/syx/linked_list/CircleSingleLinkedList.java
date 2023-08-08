package com.syx.linked_list;

/**
 * ClassName: CircleSingleLinkedList <br/>
 * Description: <br/>
 * date: 2023/7/27 17:24 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class CircleSingleLinkedList {
    private CNode first = new CNode(0, "");
    private CNode last = null;

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
//        CNode cNode1 = new CNode(1, "q");
//        CNode cNode2 = new CNode(2, "q");
//        CNode cNode3 = new CNode(3, "q");
//        CNode cNode4 = new CNode(4, "q");
//        CNode cNode5 = new CNode(5, "q");
//        circleSingleLinkedList.addCNode(cNode1);
//        circleSingleLinkedList.addCNode(cNode2);
//        circleSingleLinkedList.addCNode(cNode3);
//        circleSingleLinkedList.addCNode(cNode4);
//        circleSingleLinkedList.addCNode(cNode5);
        circleSingleLinkedList.showList();
        for (int i = 1; i<=5;i++){
            circleSingleLinkedList.addCNode(new CNode(i,i+""));
        }
        circleSingleLinkedList.outList(1,2,5);
    }

    public void addCNode(CNode cNode) {
        if (first.getNext() == null) {
            first = cNode;
            first.setNext(first);
            last = first;
        } else {
            cNode.setNext(first);
            last.setNext(cNode);
            last = cNode;
        }
    }

    public void showList() {
        if (first.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        CNode temp = first;
        while (true) {
            System.out.println(temp.getId() + "\t");
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }

    }

    public void outList(int startNo, int countNum, int nums) {
        if(first.getNext() == null || startNo < 1 || startNo >nums){
            System.out.println("无效数据");
            return;
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
        }
        while (first.getNext() != first) {
            for (int i = 0; i < countNum - 2; i++) {
                first = first.getNext();
            }
            System.out.println(first.getNext().getId() + "\t");
            first.setNext(first.getNext().getNext());
            first = first.getNext();
        }
        System.out.println(first.getId());
    }

}

class CNode {
    private int id;
    private String name;
    private CNode next;

    public CNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CNode getNext() {
        return next;
    }

    public void setNext(CNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CNode{" +
                "id=" + id +
                ", name='" + name + "}";
    }

}
