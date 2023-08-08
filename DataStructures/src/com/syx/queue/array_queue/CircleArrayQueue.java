package com.syx.queue.array_queue;

/**
 * ClassName: CircleArrayQueue <br/>
 * Description: 用数组模拟的环形队列，将队列容量空出一个作为约定。<br/>
 * 判断队列满的条件为(rear+1)%maxSize == front，判空仍为rear == front。<br/>
 * 现在front为队列的第一个元素，初始为0，rear为队列最后一个元素的下一个位置，<br/>
 * 初始也为0，这样队列中有效的数据个数为(rear + maxSize - front)%maxSize<br/>
 * date: 2023/7/24 13:57 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class CircleArrayQueue {
    private int maxSize;
    private int front;//指向队列头部的元素
    private int rear;//指向队列最后一个元素的下一个位置
    private Object[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
        //rear 和 front 默认就是0
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(Object param) {
        if (isFull()) {
            System.out.println("队列已经满了");
            return;
        }
        arr[rear] = param;
        rear = (rear + 1) % maxSize;
    }

    public Object getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        Object temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxSize] + "\t");
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    public Object headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
        }
        return arr[front];
    }

}
