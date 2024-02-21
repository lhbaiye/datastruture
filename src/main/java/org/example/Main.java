package org.example;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Main {

    private static Unsafe unsafe;
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Counter {
        private volatile int value;
        public Counter(int initialValue) {
            this.value = initialValue;
        }
        public void increment() {
            int current;
            int next;
            do {
                current = value;
                next = current + 1;
            } while (!unsafe.compareAndSwapInt(this, valueOffSet, current, next));
        }
    }

    private static final long valueOffSet;

    static {
        try {
            valueOffSet = unsafe.objectFieldOffset(Counter.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}