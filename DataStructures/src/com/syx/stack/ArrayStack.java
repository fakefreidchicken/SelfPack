package com.syx.stack;

import java.util.Scanner;

/**
 * ClassName: ArrayStack <br/>
 * Description: <br/>
 * date: 2023/7/28 15:46 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class ArrayStack<T> {

    private int maxSize;
    private Object [] stack;
    private int top = -1;

    public static void main(String[] args) {
        ArrayStack<String> stringArrayStack = new ArrayStack<String>(4);
        String key = "";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            System.out.println("1:显示栈");
            System.out.println("2:退出");
            System.out.println("3:入栈");
            System.out.println("4:出栈");
            System.out.println("输入选择");
            key = scanner.next();
            switch (key){
                case "1":
                    stringArrayStack.list();
                    break;
                case "3":
                    stringArrayStack.push(scanner.next());
                    break;
                case "4":
                    System.out.println(stringArrayStack.pop());
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    public T pop(){

        if (isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return (T)stack[top--];
    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top ; i >= 0;i--){
            System.out.println(stack[i]+" ");
        }
    }

}



