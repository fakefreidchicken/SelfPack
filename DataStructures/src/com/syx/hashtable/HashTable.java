package com.syx.hashtable;

/**
 * ClassName: HashTable <br/>
 * Description: <br/>
 * date: 2023/8/7 19:43 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class HashTable {
    private NodeLinkedList[] nodeLinkedListArray;
    private int size;

    public HashTable(int capacity) {
        this.size = capacity;
        this.nodeLinkedListArray = new NodeLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            nodeLinkedListArray[i] = new NodeLinkedList();
        }
    }

    public void put(int key, int value) {
        int index = hashFunc(key);
        Node node = new Node(key, value);
        nodeLinkedListArray[index].add(node);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            nodeLinkedListArray[i].list(i);
        }
    }

    public void findByKey(int key) {
        int index = hashFunc(key);
        Node cur = nodeLinkedListArray[index].get(key);
        if (cur != null) {
            System.out.println(cur.key + " " + cur.value);
        } else {
            System.out.println("not found");
        }

    }

    public void removeByKey(int key) {
        int index = hashFunc(key);
        Node cur = nodeLinkedListArray[index].get(key);
        if (cur != null) {
            nodeLinkedListArray[index].remove(key);
        } else {
            System.out.println("not found");
        }
    }

    public int hashFunc(int key) {
        return key % size;
    }
}

class Node {
    public int key;
    public int value;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

class NodeLinkedList {
    private Node head;

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void list(int no) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (true) {
            System.out.println(cur.key + " " + cur.value);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public Node get(int key) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.key == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(int key) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.key == key) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
    }

}