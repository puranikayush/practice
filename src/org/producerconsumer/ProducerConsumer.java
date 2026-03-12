package org.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private final Queue<Integer> queue;
    private final int capacity;
    private int size;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final VersionSelection version;

    private final Object notFullObject = new Object();
    private final Object notEmptyObject = new Object();


    public ProducerConsumer(int capacity, VersionSelection version_) {
        queue = new LinkedList<>();
        this.capacity = capacity;
        this.version = version_;
        size = 0;
    }

    public void put_v1(int number) {
        lock.lock();
        try {
            while (size >= capacity) {
                System.out.println("Waiting : Queue is full");
                notFull.await();
            }
            queue.add(number);
            size++;
            System.out.printf("size after put - %s\n", size);
            notEmpty.signalAll();
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            lock.unlock();
        }
    }

    public void put_v2(int number) {
        synchronized (queue) {
            try {
                while (size >= capacity) {
                    System.out.println("Waiting : Queue is full");
                    queue.wait();
                }
                queue.add(number);
                size++;
                System.out.printf("size after put - %s\n", size);
                queue.notifyAll();
            } catch (Exception e) {
                System.out.println("Exception while put");
            }
        }
    }

    public int take_v1() {
        lock.lock();
        try {
            while (size == 0) {
                System.out.println("Waiting : Queue is empty");
                notEmpty.await();
            }
            int poll = queue.poll();
            size--;
            System.out.printf("size after take - %s}\n", size);
            notFull.signalAll();
            return poll;
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            lock.unlock();
        }
        return -1;
    }

    public int take_v2() {
        synchronized (queue) {
            try {
                while (size == 0) {
                    System.out.println("Waiting : Queue is empty");
                    queue.wait();
                }
                int poll = queue.poll();
                size--;
                System.out.printf("size after take - %s}\n", size);
                queue.notifyAll();
                return poll;
            } catch (Exception e) {
                System.out.println("Exception while take");
            }
        }
        return -1;
    }

    public void producer() {
        Random random = new Random();
        switch (this.version) {
            case V1 -> {
                while (true) {
                    put_v1(random.nextInt(0, 100));
                }
            }
            case V2 -> {
                while (true) {
                    put_v2(random.nextInt(0, 100));
                }
            }

        }
    }

    public void consumer() {
        switch (this.version) {
            case V1 -> {
                while (true) {
                    System.out.println(take_v1());
                }
            }
            case V2 -> {
                while (true) {
                    System.out.println(take_v2());
                }
            }
        }
    }

}
