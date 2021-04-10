package test;

import util.Test;

import java.util.concurrent.locks.ReentrantLock;

public class Uninterruptible {
    private static final Object o1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        synchronized (Test.class) {
            System.out.println(1);
        }
    }
}