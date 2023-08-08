package com.syx.queue.array_queue;

/**
 * ClassName: ArrayQueue <br/>
 * Description: 用数组实现的单队列<br/>
 * date: 2023/7/24 10:58 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class ArrayQueue {
    private int maxSize;
    private int front;//指向队列头部的前一个元素
    private int rear;//指向队列最后一个元素
    private Object[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new Object[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    public boolean isEmpty(){
        return rear == front;
    }
    public void addQueue(Object param){
        if(isFull()){
            System.out.println("队列已经满了");
            return;
        }
        arr[++rear] = param;
    }
    public Object getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (Object o : arr) {
            System.out.print(o+"\t");
        }
    }
    public Object headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
        }
        return arr[front+1];
    }
}
