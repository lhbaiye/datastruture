package org.example.datastructure.queue;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description array queue demo
 * @date 2023/12/6 20:15:10
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }


}

class ArrayQueue {
    private int maxSize;     // 队列最大容量
    private int front; // 队列头，指向第一个位置
    private int end; //队尾元素
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.end = -1;
    }

    /**
     * 获取队列数据
     * @return
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[++front];
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满了");
        }
        arr[++end] = n;
    }
    public void show() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d \n", i, arr[i]);
        }
    }

    public boolean isEmpty() {
        return end == front;
    }
    // 队列是否已满
    private boolean isFull() {
        return end == maxSize - 1;
    }

}

class CircleQueue {
    private int maxSize; //最大容量
    private int front; //队列头，指向队列头的元素
    private int rear; //队列尾，指向队尾的下一个元素
    private int[] arr; // 队列

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public int get() {
        if (isEmpty()) {
            System.out.println("队列空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满了");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队里为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            int index = i % maxSize;
            System.out.printf("arr[%d] = %d \n", index, arr[index]);
        }
    }

    /**
     * 查看队列的头部数据，注意：不是取出数据，只是查看
     *
     * @return
     */
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }

    public int tail() {
        if (isEmpty()) {
            System.out.println();
        }
        return rear - 1 < 0 ? arr[maxSize - 1] : arr[rear - 1];

    }

    // 有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }



    // 队列是否已满
    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
}