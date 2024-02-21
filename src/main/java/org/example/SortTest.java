package org.example;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/29 15:38:46
 */
public class SortTest {
    private static final Object lock = new Object();
    private static volatile int count = 0;
    private static final int max = 100;

    static class Seq implements Runnable {
        private final int index;
        public Seq(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (count < max) {
                synchronized (lock) {
                    try {
                        while (count % 3 != index) {
                            lock.wait();
                        }
                        if (count < max) {
                            System.out.println();
                        }
                        count++;
                        lock.notifyAll();;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
